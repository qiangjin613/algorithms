package pta.basic;

import java.util.Scanner;

/**
 * 1012 数字分类 (20 分)
 * 技巧：对与有错误标志并且输出在程序结束后的情况，可使用一个标记数组，对结果进行标记
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[6];
        double a4 = 0;
        boolean[] result = new boolean[6];
        int inputNum, flag = 1, count = 0;
        while (n-- != 0) {
            inputNum = in.nextInt();
            switch (inputNum % 5) {
                case 0:
                    if (inputNum % 2 == 0) {
                        a[1] += inputNum;
                        result[1] = true;
                    }
                    break;
                case 1:
                    a[2] += inputNum * flag;
                    result[2] = true;
                    flag *= -1;
                    break;
                case 2:
                    a[3]++;
                    result[3] = true;
                    break;
                case 3:
                    a4 += inputNum;
                    result[4] = true;
                    count++;
                    break;
                case 4:
                    a[5] = inputNum > a[5] ? inputNum : a[5];
                    result[5] = true;
                    break;
                default:
            }
        }
        if (a4 != 0) {
            a4 /= count;
        }
        // 输出结果
        for (int i = 1; i < 6; i++) {
            if (!result[i]) {
                System.out.print("N");
            } else {
                if (i == 4) {
                    System.out.format("%.1f", a4);
                } else {
                    System.out.print(a[i]);
                }
            }
            if (i < 5) {
                System.out.print(" ");
            }
        }
    }
}
