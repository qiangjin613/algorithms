package leetcode;

import java.util.Arrays;

/**
 * 370. 区间加法
 */
public class Solution_370 {

    int[] getModifiedArray(int length, int[][] updates) {
        int[] array = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int startIndex = updates[i][0];
            int endIndex = updates[i][1];
            int inc = updates[i][2];
            array[startIndex] += inc;
            if (endIndex < array.length - 1) {
                array[endIndex + 1] -= inc;
            }
        }
        // 构造原始数组
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i - 1];
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_370().getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}})));
    }
}
