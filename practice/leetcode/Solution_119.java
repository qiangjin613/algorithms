package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/">119. 杨辉三角 II</a>
 *
 * @see Solution_118
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_119 {

    /**
     * 由于只需要结果行，可采用<b>滚动数组</b>的思想对空间复杂度进行优化
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preRow = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> curRow = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curRow.add(1);
                } else {
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            preRow = curRow;
        }
        return preRow;
    }

    /**
     * 使用数组对 getRow() 进行优化：避免拆装箱对性能的影响，避免不断申请内存造成的消耗
     */
    public List<Integer> getRow2(int rowIndex) {
        int[] preRow, curRow, swapVar;
        preRow = new int[rowIndex + 1];
        swapVar = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            curRow = swapVar;
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curRow[j] = 1;
                } else {
                    curRow[j] = preRow[j - 1] + preRow[j];
                }
            }
            swapVar = preRow;
            preRow = curRow;
        }
        List<Integer> current = new ArrayList<>(rowIndex);
        for (int i = 0; i <= rowIndex; i++) {
            current.add(preRow[i]);
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_119().getRow(4));
        System.out.println(new Solution_119().getRow2(4));
    }
}
