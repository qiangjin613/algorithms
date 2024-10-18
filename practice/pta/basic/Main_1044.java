package pta.basic;

import java.util.Scanner;

/**
 * 1044 火星数字 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1044 {
    public static void main(String[] args) {
        String[][] hx = {
                {"tret", "jan", "feb", "mar", "apr", "may", "jun", "jly", "aug", "sep", "oct", "nov", "dec"},
                {"", "tam", "hel", "maa", "huh", "tou", "kes", "hei", "elo", "syy", "lok", "mer", "jou"}
        };

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String input;
        while (n-- != 0) {
            input = in.nextLine();
            /* 地球 --> 火星 */
            if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
                int temp = Integer.parseInt(input);
                int h = temp / 13;
                int l = temp % 13;
                /* 输出高位 */
                if (h != 0) {
                    System.out.print(hx[1][h]);
                }
                if (h != 0 && l != 0) {
                    System.out.print(" ");
                }
                if (l != 0 || h == 0) {
                    System.out.print(hx[0][l]);
                }
                System.out.println();
            }
            /* 火星 --> 地球 */
            else {
                int out = 0, exp = 1;
                String[] temp = input.split(" ");
                for (int i = temp.length - 1; i >= 0; i--) {
                    int index = findIndex(hx[0], temp[i]);
                    if (index != -1 && i == temp.length - 1) {
                        out += index;
                    } else {
                        out += findIndex(hx[1], temp[i]) * 13;
                    }
                }
                System.out.println(out);
            }
        }
    }

    public static int findIndex(String[] args, String str) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
