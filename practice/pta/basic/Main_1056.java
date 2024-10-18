package pta.basic;

import java.util.Scanner;

/**
 * 1056 组合数的和 (15 分)
 */
public class Main_1056 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int sum = 0;
        // 两个 for 循环，对 2 位数进行遍历操作；如果是 3 位数，则需要 3 层循环（或使用 排列组合相关 算法）
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                sum += nums[i] * 10 + nums[j];
            }
        }
        System.out.print(sum);
    }
}