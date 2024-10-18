package pta.basic;

import java.util.Scanner;

/**
 * 1021 个位数统计 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int[] result = new int[10];
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '0': result[0]++; break;
                case '1': result[1]++; break;
                case '2': result[2]++; break;
                case '3': result[3]++; break;
                case '4': result[4]++; break;
                case '5': result[5]++; break;
                case '6': result[6]++; break;
                case '7': result[7]++; break;
                case '8': result[8]++; break;
                case '9': result[9]++; break;
                default: break;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                System.out.println(i + ":" + result[i]);
            }
        }
    }
}
