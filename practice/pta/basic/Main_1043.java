package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1043 输出PATest (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 统计 P、A、T、e、s、t 个数：
        String str = "PATest";
        int[] stats = new int[6];
        int cnt = 0;
        for (int i = 0, len = input.length(); i < len; i++) {
            char c = input.charAt(i);
            switch (c) {
                case 'P': stats[0]++; cnt++; break;
                case 'A': stats[1]++; cnt++; break;
                case 'T': stats[2]++; cnt++; break;
                case 'e': stats[3]++; cnt++; break;
                case 's': stats[4]++; cnt++; break;
                case 't': stats[5]++; cnt++; break;
            }
        }
        // 输出结果：
        StringBuilder output = new StringBuilder(cnt);
        // 确定轮数：
        for (int i = 0; i < cnt;) {
            for (int j = 0; j < 6; j++) {
                if (stats[j]-- > 0) {
                    output.append(str.charAt(j));
                    i++;
                }
            }
        }
        System.out.print(output);
    }
}
