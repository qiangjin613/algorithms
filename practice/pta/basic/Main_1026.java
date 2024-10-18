package pta.basic;

import java.util.Scanner;

/**
 * 1026 程序运行时间 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1026 {
    static final int CLK_TCK = 100;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c1 = in.nextInt();
        int c2 = in.nextInt();

        int h, m, s;
        int temp = (c2 - c1 + 50) / CLK_TCK; // 加 50 是为了对不足 1s 的时间进行四舍五入
        h = temp / (60*60);
        temp -= h * 60 * 60;
        m = temp / 60;
        s = temp - m * 60;
        System.out.printf("%02d:%02d:%02d", h, m, s);
    }
}
