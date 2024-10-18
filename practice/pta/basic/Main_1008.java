package pta.basic;

import java.util.Scanner;

/**
 * 1008 数组元素循环右移问题 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] num = new int[n];
        // 利用循环队列的思想，这里的步长为 m
        for (int i = 0; i < n; i++) {
            num[(i + m) % n] = in.nextInt();
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            System.out.format("%s%d", flag ? " " : "", num[i]);
            flag = true;
        }
    }

    /**
     * 还有一种比较麻烦的方法：让字符串序列翻转三次
     * 1) 翻转(0, n)
     * 2) 翻转(0, m % n)
     * 3) 翻转[m % n, n)
     */
}
