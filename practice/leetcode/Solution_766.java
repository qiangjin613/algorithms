package leetcode;

/**
 * <a href="https://leetcode.cn/problems/toeplitz-matrix/">766. 托普利茨矩阵</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 边界处理
                if (i + 1 >= matrix.length || j + 1 >= matrix[0].length) {
                    continue;
                }
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_766().isToeplitzMatrix(new int[][]{
                {1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}
        }));
    }
}
