package leetcode;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.cn/problems/spiral-matrix-ii/">59. 螺旋矩阵 II</a>
 */
public class Solution_59 {

    public int[][] generateMatrix(int n) {
        int top = 0, tail = n - 1, left = 0, right = n - 1;
        int[][] matrix = new int[n][n];
        int step = 1;
        while (step <= n * n) {
            if (top <= tail) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = step++;
                }
                top++;
            }

            if (left <= right) {
                for (int i = top; i <= tail; i++) {
                    matrix[i][right] = step++;
                }
                right--;
            }

            if (top <= tail) {
                for (int i = right; i >= left; i--) {
                    matrix[tail][i] = step++;
                }
                tail--;
            }

            if (left <= right) {
                for (int i = tail; i >= top; i--) {
                    matrix[i][left] = step++;
                }
                left++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        for (int[] ints : new Solution_59().generateMatrix(3)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
