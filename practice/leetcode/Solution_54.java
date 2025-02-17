package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.cn/problems/spiral-matrix/">54. 螺旋矩阵</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_54 {

    /**
     * 定义 上、下、左、右 四个边界
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, tail = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int allSize = matrix[0].length * matrix.length;
        List<Integer> res = new ArrayList<>(allSize);
        int step = 0;
        while (step < allSize) {
            if (top <= tail) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                    step++;
                }
                top++;
            }

            if (left <= right) {
                for (int i = top; i <= tail; i++) {
                    res.add(matrix[i][right]);
                    step++;
                }
                right--;
            }

            if (top <= tail) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[tail][i]);
                    step++;
                }
                tail--;
            }

            if (left <= right) {
                for (int i = tail; i >= top; i--) {
                    res.add(matrix[i][left]);
                    step++;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_54().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}) + "");
    }
}
