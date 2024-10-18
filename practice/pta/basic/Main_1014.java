package pta.basic;

import java.util.Scanner;

/**
 * 1014 福尔摩斯的约会 (20 分)
 * 坑点：
 *      线索 1 的字母范围是 [A, G]
 *      线索 2 的字母范围是 [A, N] U [0, 9]
 *      线索 3 的字母范围是 [A, Z] U [a, z]
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = new String[4];
        for (int i = 0; i < 4; i++) {
            input[i] = in.next();
        }
        String[] week = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        String time = "0123456789ABCDEFGHIGKLMN";
        /* 代表第 cnt 条线索（从 0 开始） */
        int cnt = 0;
        LOOP:
        for (int i = 0; i < 4; i += 2) {
            for (int p = 0; p < input[i].length() && p < input[i + 1].length(); p++) {
                char c = input[i].charAt(p);
                if (c == input[i + 1].charAt(p)) {
                    switch (cnt) {
                        case 0:
                            if (c >= 'A' && c <= 'G') {
                                System.out.print(week[c - 'A'] + " ");
                                cnt++;
                            }
                            break;
                        case 1:
                            if ((c >= 'A' && c <= 'N') || (c >= '0' && c <= '9')) {
                                System.out.format("%02d:", time.indexOf(c));
                                cnt++;
                                continue LOOP;
                            }
                            break;
                        default:
                            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                                System.out.format("%02d", p);
                                return;
                            }
                    }
                }
            }
        }
    }
}
