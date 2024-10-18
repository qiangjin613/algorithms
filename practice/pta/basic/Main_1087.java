package pta.basic;

import java.util.Scanner;

/**
 * 1087 有多少不同的值 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1087 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0, sign = -1;
        for (int i = 1; i <= n; i++) {
            int temp = i/2 + i/3 + i/5;
            if (sign != temp) {
                cnt++;
                sign = temp;
            }
        }
        System.out.print(cnt);
    }
}
