package pta.basic;

import java.util.Scanner;

/**
 * 1062 最简分数 (20 分)
 * 注：对于范围应该是 (n1/m1, n2/m2)
 *         while (n1 * k >= i * m1) {
 *             i++;
 *         }
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1062 {
    public static void main(String[] args) {
        // 录入数据
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        String[] number1 = input[0].split("/");
        int n1 = Integer.parseInt(number1[0]);
        int m1 = Integer.parseInt(number1[1]);
        String[] number2 = input[1].split("/");
        int n2 = Integer.parseInt(number2[0]);
        int m2 = Integer.parseInt(number2[1]);
        int k = Integer.parseInt(input[2]);
        // 处理大小边界，使得 n1/m1 < n2/m2
        if (n1 * m2 > m1 * n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
            temp = m1;
            m1 = m2;
            m2 = temp;
        }
        // 查找合法的输出
        boolean flag = false;
        int i = 1;
        while (n1 * k >= i * m1) {
            i++;
        }
        while (n2 * k > i * m2 ) {
            if (gcd(i, k) == 1) {
                System.out.format("%s%d/%d", flag? " ": "", i, k);
                flag = true;
            }
            i++;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
