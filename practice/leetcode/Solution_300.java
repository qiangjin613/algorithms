package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_300 {

    /**
     * 时间复杂度：O(n^2)
     */
    public int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            // 寻找 nums[0 ... i - 1] 中比 nums[i] 小的元素，
            // 把 nums[i] 接在后面，就能形成递增子序列
            // 这时，只需要把最大长度的子序列记录下来，就是 dp[i]
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int ans = 1;
        for (int i : dp) {
            if (i > ans) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_300().lengthOfLIS(new int[] {0,1,0,3,2,3}));
    }
}
