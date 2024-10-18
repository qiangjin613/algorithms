package pta.basic;

import java.util.Scanner;

/**
 * 1088 三人行 (20 分)
 * 设：甲、乙、丙 的能量值为：a、b、c
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1088 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        for (int a = 99; a >= 10; a--) {
            int b = a % 10 * 10 + a / 10;
            double c = Math.abs(a - b) * 1.0 / x;
            if (c * y == b) {
                System.out.print(a);
                print(a, m);
                print(b, m);
                print(c, m);
                return;
            }
        }
        System.out.print("No Solution");
    }

    private static void print(double t, int m) {
        if (t > m) {
            System.out.print(" Cong");
        } else if (t == m) {
            System.out.print(" Ping");
        } else {
            System.out.print(" Gai");
        }
    }
}
