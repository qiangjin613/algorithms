package leetcode;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.cn/problems/rotate-image/">48. 旋转图像</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_48 {

    /**
     * 空间复杂度 O(n)
     */
    public void rotate(int[][] matrix) {
        int[][] dummy = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dummy[j][matrix[i].length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < dummy.length; i++) {
            for (int j = 0; j < dummy[i].length; j++) {
                matrix[i][j] = dummy[i][j];
            }
        }
    }

    /**
     * 空间复杂度 O(1)
     */
    public void rotate2(int[][] matrix) {
        // 对称轴反转
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 每行反转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new Solution_48().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {7, 6, 5, 4}, {4, 1, 2, 3}};
        new Solution_48().rotate2(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
    }
}
