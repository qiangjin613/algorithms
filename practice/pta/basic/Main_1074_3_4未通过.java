package pta.basic;

import java.util.Scanner;

/**
 * 1074 宇宙无敌加法器 (20 分)
 */
public class Main_1074_3_4未通过 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        String a = in.next();
        String b = in.next();
        StringBuilder c = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1, k = n.length() - 1;
                 i >= 0 || j >= 0 || carry > 0;
                 i--, j--, k--) {
            /* 基数 */
            int radix = 10;
            if (k >= 0 && n.charAt(k) >= '2' && n.charAt(k) <= '9') {
                radix = n.charAt(k) - '0';
            }

            int ai = 0, bj = 0;
            if (i >= 0) {
                ai = a.charAt(i) - '0';
            }
            if (j >= 0) {
                bj = b.charAt(j) - '0';
            }
            carry += ai + bj;
            c.insert(0, carry % radix);
            carry /= radix;
        }
        System.out.println(Integer.parseInt(c.toString()));
    }
}
