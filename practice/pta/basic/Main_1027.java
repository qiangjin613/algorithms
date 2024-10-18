package pta.basic;

import java.util.Scanner;

/**
 * 1027 打印沙漏 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1027 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String c = in.next();
        // stats 为打印 i 层沙漏总共使用的符号数
        int stats = 1, i = 1;
        while (stats <= n) {
            i += 2;
            stats = stats + i * 2;
        }
        stats = stats - i * 2;
        i -= 2;
        // 打印上三角
        for (int j = 0; j < i; j += 2) {
            for (int k = 0; k < j / 2; k++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i - j; k++) {
                System.out.print(c);
            }
            System.out.println();
        }
        // 打印下三角（从第二行开始）
        for (int j = 2; j < i; j += 2) {
            for (int k = 0; k < (i - j) / 2; k++) {
                System.out.print(" ");
            }
            for (int k = 0; k < j + 1; k++) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.print(n - stats);
    }
}
