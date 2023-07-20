package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle/">118. 杨辉三角</a>
 *
 * @see Solution_119
 */
public class Solution_118 {

    /**
     * 从杨辉三角的性质出发：每个数字等于上一行的左右两个数字之和。
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        // 填充首行数据
        List<Integer> firstRow = new ArrayList<>(1);
        firstRow.add(1);
        result.add(firstRow);
        // 从第二行开始计算
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>(i);
            List<Integer> preRow = result.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    currentRow.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            result.add(currentRow);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_118().generate(30));
    }
}
