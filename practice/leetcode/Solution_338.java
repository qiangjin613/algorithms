package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/counting-bits/">338. 比特位计数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_338 {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    /**
     * 解法 2：DP
     * <a href="https://leetcode.cn/problems/counting-bits/solutions/7882/hen-qing-xi-de-si-lu-by-duadua/">清晰的思路</a>
     */
    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i / 2];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_338().countBits(2)));
        System.out.println(Arrays.toString(new Solution_338().countBits(5)));
    }
}
