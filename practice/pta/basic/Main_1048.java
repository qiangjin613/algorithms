package pta.basic;

import java.util.Scanner;

/**
 * 1048 数字加密 (20 分)
 * 对于这个题目：在运算前补 0，让 A、B 长度相等是一个很好的办法，能有效避坑...
 * 也可以使用下面的一种解法，在循环中补 0
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1048 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        String num = "0123456789JQK";
        StringBuilder output = new StringBuilder(b.length());
        for (int i = 1; i <= b.length() || i <= a.length(); i++) {
            int indexA = a.length() - i;
            int anum = indexA >= 0? a.charAt(indexA) - '0': 0;
            int indexB = b.length() - i;
            int bnum = indexB >= 0? b.charAt(indexB) - '0': 0;
            if (i % 2 == 1) {
                int temp = (anum + bnum) % 13;
                output.insert(0, num.charAt(temp));
            } else {
                int temp = bnum - anum;
                output.insert(0, temp >= 0 ? temp: temp + 10);
            }
        }
        System.out.print(output.toString());
    }
}
