package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-falling-path-sum/">931. 下降路径最小和</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_931 {

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;

        memo = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        // 从下面的一行找最小值
        for (int j = 0; j < matrix.length; j++) {
            res = Math.min(res, dp(matrix, matrix.length - 1, j));
        }
        return res;
    }

    /**
     * 从第一行 matrix[0][0 ... n] 向下走，落到 matrix[i][j] 的最小路径和是 dp(matrix, i, j)
     *
     * <p>Note：需使用备忘录进行剪枝，消除重叠子问题
     */
    int dp(int[][] matrix, int i, int j) {
        // 边界检查
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length) {
            return Integer.MAX_VALUE;
        }

        // 查备忘录
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }

        // base case
        if (i == 0) {
            return matrix[i][j];
        }

        // 状态转移，且更新备忘录
        memo[i][j] = matrix[i][j] + Math.min(dp(matrix, i - 1, j - 1),
                Math.min(dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1)));

        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_931().minFallingPathSum(new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        }));
    }
}
