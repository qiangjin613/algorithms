package pta.basic;

import java.util.Scanner;

/**
 * 1011 A+B 和 C (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long a, b, c;
        for (int i = 0; i < t; i++) {
            a = in.nextLong();
            b = in.nextLong();
            c = in.nextLong();
            if (a + b > c) {
                System.out.print("Case #" + (i + 1) + ": true");
            } else {
                System.out.print("Case #" + (i + 1) + ": false");
            }
            if (i < t - 1) {
                System.out.println();
            }
        }
    }
}
