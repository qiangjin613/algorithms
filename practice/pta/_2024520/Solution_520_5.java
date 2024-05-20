package pta._2024520;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_520_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();

        int[] nums = new int[501];
        Arrays.fill(nums, 0);
        int min = 500, temp, curNum;
        for (int i = 0; i < total; i++) {
            temp = scanner.nextInt();
            curNum = Math.abs(300 - temp);
            if (curNum < min) {
                min = curNum;
            }
            nums[temp]++;
        }

        int res = 0;
        if (min + 300 <= 500 && min + 300 >= 0) {
            res += nums[min + 300];
        }
        if (300 - min >= 0) {
            res += nums[300 - min];
        }
        System.out.println(res);
    }
}
