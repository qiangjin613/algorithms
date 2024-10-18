package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1083 是否存在相等的差 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int[] stats = new int[n + 1];
        for (int i = 0, len = input.length(); i < len; i += 2) {
            int temp = input.charAt(i) - '0';
            stats[Math.abs(temp - i/2 - 1)]++;
        }
        for (int i = stats.length - 1; i > 0; i--) {
            if (stats[i] > 1) {
                System.out.println(i + " " + stats[i]);
            }
        }
    }
}
