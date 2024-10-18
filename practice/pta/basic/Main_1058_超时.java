package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1058 选择题 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1058_超时 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        // 录入题目：
        String[] question = new String[m];
        for (int i = 0; i < m; i++) {
            question[i] = br.readLine();
        }
        // 判题并统计：
        int[] stats = new int[m];
        int max = 0;
        /* 第 i+1 个学生 */
        for (int i = 0; i < n; i++) {
            int sum = 0;
            input = br.readLine().split("\\) ?");
            /* 第 i+1 个学生的 第 j+1 题 */
            for (int j = 0; j < m; j++) {
                int p, q;
                for (p = 1, q = 4; p < input[j].length() && q < question[j].length(); p++, q++) {
                    if (input[j].charAt(p) != question[j].charAt(q)) {
                        break;
                    }
                }
                if (p == input[j].length() && q == question[j].length()) {
                    sum += question[j].charAt(0) - '0';
                } else {
                    stats[j]++;
                    if (max < stats[j]) {
                        max = stats[j];
                    }
                }
            }
            System.out.println(sum);
        }
        // 输出结果：
        if (max == 0) {
            System.out.print("Too simple");
        } else {
            System.out.print(max);
            StringBuilder output = new StringBuilder(m);
            for (int i = 0; i < stats.length; i++) {
                if (stats[i] == max) {
                    output.append(" ").append(i + 1);
                }
            }
            System.out.print(output);
        }
    }
}
