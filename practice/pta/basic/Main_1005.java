package pta.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1005 继续(3n+1)猜想 (25 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] ns = new int[k];
        boolean[] flag = new boolean[5000];
        for (int i = 0; i < k; i++) {
            ns[i] = in.nextInt();

            int temp = ns[i];
            /* 如果 temp 没有被覆盖，则进行计算 */
            if (!flag[temp]) {
                while (temp != 1) {
                    if (temp % 2 == 0) {
                        temp = temp / 2;
                    } else {
                        temp = (3 * temp + 1) / 2;
                    }
                    flag[temp] = true;
                }
            }
        }
        /* 对录入数据进行排序 */
        Arrays.sort(ns);
        boolean sign = false;
        for (int i = ns.length - 1; i >= 0 ; i--) {
            if (!flag[ns[i]]) {
                System.out.format("%s%d", sign ? " " : "", ns[i]);
                sign = true;
            }
        }
    }
}
