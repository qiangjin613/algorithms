package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1057 数零壹 (20 分)
 * 注：一串长度未 10^5 的字符串勉强可以在 200ms 内完成，不过这需要多次提交，才能 AC
 */
public class Main_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 统计字符
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                sum += str.charAt(i) - 'a' + 1;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sum += str.charAt(i) - 'A' + 1;
            }
        }
        // 计算 0、1 数量
        int count0 = 0, count1 = 0;
        while (sum != 0) {
            switch (sum % 2) {
                case 0: count0++; break;
                case 1: count1++; break;
                default:
            }
            sum /= 2;
        }
        System.out.print(count0 + " " + count1);
    }
}