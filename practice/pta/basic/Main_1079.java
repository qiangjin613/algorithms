package pta.basic;

import java.util.Scanner;

/**
 * 1079 延迟的回文数 (20 分)
 * 在本题中有 2 个不明确的点：
 *  1. [0,9] 都是回文数
 *  2. 对于 n 如果就是回文数，就直接输出，不进行计算。
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1079 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder n = new StringBuilder().append(in.next());
        int cnt = 0;
        StringBuilder a, b;
        while (!judge(n) && cnt < 10) {
            cnt++;
            a = new StringBuilder(n);
            b = n.reverse();
            n = add(a, b);
            System.out.println(a + " + " + b + " = " + n);
        }
        if (cnt >= 10 && !judge(n)) {
            System.out.print("Not found in 10 iterations.");
        } else {
            System.out.print(n + " is a palindromic number.");
        }
    }

    /**
     * 非负整数加法
     */
    public static StringBuilder add(StringBuilder a, StringBuilder b) {
        StringBuilder c = new StringBuilder(a.length());
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            carry = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            c.insert(0, carry % 10);
            carry /= 10;
        }
        if (carry != 0) {
            c.insert(0, carry);
        }
        return c;
    }

    /**
     * 判断是不是一个回文数
     */
    public static boolean judge(StringBuilder n) {
        int len = n.length();
        for (int i = 0; i < len / 2; i++) {
            if (n.charAt(i) != n.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
