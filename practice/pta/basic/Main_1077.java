package pta.basic;

import java.util.Scanner;

/**
 * 1077 互评成绩计算 (20 分)
 * 注：最后一个点可能会超时，多次提交即可 AC
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1077 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] score = new int[n];
        while (n-- != 0) {
            input = in.nextLine().split(" ");
            // 老师的分数
            score[0] = Integer.parseInt(input[0]);
            // 学生的分数
            int count = 0, sum = 0, min = m + 1, max = 0;
            for (int i = 1; i < input.length; i++) {
                score[i] = Integer.parseInt(input[i]);
                if (score[i] >= 0 && score[i] <= m) {
                    count++;
                    sum += score[i];
                    if (score[i] > max) {
                        max = score[i];
                    }
                    if (score[i] < min) {
                        min = score[i];
                    }
                } else {
                    score[i] = 0;
                }
            }
            int g2 = (sum - (min + max)) / (count - 2);
            System.out.format("%.0f%n", (score[0] + g2) / 2.0);
        }
    }
}
