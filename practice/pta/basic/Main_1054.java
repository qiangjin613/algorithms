package pta.basic;

import java.util.Scanner;

/**
 * 1054 求平均值 (20 分)
 * 测试点：
 *      3   k == 1时，输出 number
 *      4   对于非法数 1000.1 的判断
 */
public class Main_1054 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0, k = 0;
        while (n-- != 0) {
            String input = in.next();
            if (judge(input)) {
                sum += Double.parseDouble(input) * 100;
                k++;
            } else {
                System.out.println("ERROR: " + input + " is not a legal number");
            }
        }
        System.out.print("The average of " + k);
        if (k == 0) {
            System.out.print(" numbers is Undefined");
        } else if (k == 1) {
            System.out.format(" number is %.2f", sum / 100.0);
        } else {
            System.out.format(" numbers is %.2f", sum / 100.0 / k);
        }
    }

    public static boolean judge(String s) {
        /* k 记录 '.' 的数量，sum 记录逗号前的数值大小 */
        int k = 0;
        int i = s.charAt(0) == '-'? 1: 0;
        if ("-".equals(s)) {
            return false;
        }
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || c == '.') {
                if (c == '.') {
                    k++;
                    if (i == 0 || (i == 1 && s.charAt(0) == '-') || i < s.length() - 3) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        /* 不能忽略小数点后的数值 */
        if (k > 1 || Math.abs(Double.parseDouble(s)) > 1000) {
            return false;
        }
        return true;
    }
}
