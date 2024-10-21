package leetcode;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.cn/problems/reshape-the-matrix/">566. 重塑矩阵</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }

        int[][] ans = new int[r][c];
        int i = 0, j = 0;
        for (int[] ints : mat) {
            for (int anInt : ints) {
                ans[i][j] = anInt;
                j++;
                if (j >= c) {
                    j = 0;
                    i++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution_566().matrixReshape(
                new int[][] {{1, 2}, {3, 4}},
                1,
                4)));
        System.out.println(Arrays.deepToString(new Solution_566().matrixReshape(
                new int[][] {{1, 2}, {3, 4}},
                4,
                1)));
    }
}
