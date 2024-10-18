package pta.basic;

import java.util.Scanner;

/**
 * 1086 就不告诉你 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1086 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int temp = a * b;
        int result = 0;
        while (temp != 0){
            result = result * 10 + temp % 10;
            temp /= 10;
        }
        System.out.print(result);
    }
}
