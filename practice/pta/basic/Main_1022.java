package pta.basic;

import java.util.Scanner;

/**
 * 1022 D进制的A+B (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), d = in.nextInt();
        StringBuilder output = new StringBuilder();
        int sum = a + b;
        do {
            output.append(sum % d);
            sum /= d;
        } while (sum != 0);
        System.out.print(output.reverse());
    }
}

//13 % 2 = 6 ---- 1
// 6 % 2 = 3 ---- 0
// 3 % 2 = 1 ---- 1
// 1 % 2 = 0 ---- 1
// output: 1101