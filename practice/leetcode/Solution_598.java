package leetcode;

/**
 * <a href="https://leetcode.cn/problems/longest-harmonious-subsequence/">594. 最长和谐子序列</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_598 {

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;
        for (int[] op : ops) {
            minN = Math.min(minN, op[0]);
            minM = Math.min(minM, op[1]);
        }
        return minM * minN;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_598().maxCount(3, 3, new int[][] {{2,2}, {3,3}}));
        System.out.println(new Solution_598().maxCount(92, 2, new int[][] {
                {70,1},
                {37,1},
                {3,2},
                {67,1},
                {37,2},
                {87,2},
                {26,1},
                {43,1},
                {19,1},
                {63,1},
                {67,1},
                {19,1},
                {14,2},
                {5,1},
                {27,2},
                {44,2},
                {13,1}
        }));
    }
}
