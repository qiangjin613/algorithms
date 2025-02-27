package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/russian-doll-envelopes/">354. 俄罗斯套娃信封问题</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_354 {

    /**
     * Note：这里的查找最长递增子序列需要使用二分的方式才能通过所有测试用例
     */
    public int maxEnvelopes(int[][] envelopes) {
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        // 对宽度 w 从小到大排序，确保了 w 这个维度可以互相嵌套；对高度 h 进行降序排序，保证二维 LIS 中不存在多个 w 相同的信封
        Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] hs = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            hs[i] = envelopes[i][1];
        }

        // 查找 hs 的最长递增序列
        int[] dp = new int[hs.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < hs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (hs[i] > hs[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        // 计算最长子序列
        int ans = 1;
        for (int i : dp) {
            if (i > ans) {
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_354().maxEnvelopes(new int[][]{
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        }));
    }
}
