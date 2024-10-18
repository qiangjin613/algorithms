package pta.basic;

import java.util.Scanner;

/**
 * 1034 有理数四则运算 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1034 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] temp = in.next().split("/");
        long a = Long.parseLong(temp[0]);
        long b = Long.parseLong(temp[1]);
        temp = in.next().split("/");
        long c = Long.parseLong(temp[0]);
        long d = Long.parseLong(temp[1]);

        // 约分：
        long x = gcd(a, b);
        a /= x;
        b /= x;
        x = gcd(c, d);
        c /= x;
        d /= x;

        // 输出结果：
        System.out.println(deal(a, b) + " + " + deal(c, d) + " = " + deal(a * d + b * c, b * d));
        System.out.println(deal(a, b) + " - " + deal(c, d) + " = " + deal(a * d - b * c, b * d));
        System.out.println(deal(a, b) + " * " + deal(c, d) + " = " + deal(a * c, b * d));
        System.out.print(deal(a, b) + " / " + deal(c, d) + " = ");
        if (b * c == 0) {
            System.out.print("Inf");
        } else {
            System.out.print(deal(a * d, b * c));
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a >= 0? a: -a;
        }
        return gcd(b, a % b);
    }

    public static String deal(long a, long b) {
        if (a == 0) {
            return "0";
        }

        long x = gcd(a, b);
        a /= x;
        b /= x;

        /* 标记数值正负符号 */
        boolean sign = true;
        if (a * b < 0) {
            sign = false;
        }
        /* 将 a、b 都置为正数 */
        a = a >= 0? a: -a;
        b = b >= 0? b: -b;

        StringBuilder result = new StringBuilder();
        if (!sign) {
            result.append("(-");
        }
        /* 整数 */
        long temp = a / b;
        /* 余数 */
        a %= b;

        if (temp != 0) {
            result.append(temp);
        }
        if (a != 0 && temp != 0) {
            result.append(" ");
        }
        if (a != 0) {
            result.append(a).append("/").append(b);
        }

        if (!sign) {
            result.append(")");
        }
        return result.toString();
    }
}
