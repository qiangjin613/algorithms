package pta.basic;

import java.util.Scanner;

/**
 * 1023 组个最小数 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1023 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = in.nextInt();
        }
        // 先找出除 0 外的第一个最小的数字
        for (int i = 1; i < num.length; i++) {
            if (num[i] > 0) {
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        // 升序输出剩余数字
        for (int i = 0; i < num.length; i++) {
            while (num[i] > 0) {
                System.out.print(i);
                num[i]--;
            }
        }
    }
}
