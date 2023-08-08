package leetcode;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.cn/problems/corporate-flight-bookings/">1109. 航班预订统计</a>
 */
public class Solution_1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] array = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int startIndex = bookings[i][0];
            int endIndex = bookings[i][1];
            int inc = bookings[i][2];
            array[startIndex - 1] += inc;
            if (endIndex < array.length) {
                array[endIndex] -= inc;
            }
        }
        // 构造原始数组
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i - 1];
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_1109().corpFlightBookings(new int[][]{{1,2,10},{2,3,20}, {2,5,25}}, 5)));
    }
}
