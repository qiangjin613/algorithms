package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1073 多选题常见计分法 (20 分)
 */
public class Main_1073_写了一半 {
    public static void main(String[] args) throws IOException {
        // 录入数据：
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        /* 人数 */
        int n = Integer.parseInt(input[0]);
        /* 题数 */
        int m = Integer.parseInt(input[1]);
        String[] question = new String[m];
        String[] answer = new String[n];
        for (int i = 0; i < m; i++) {
            question[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            answer[i] = br.readLine();
        }
        // 统计结果：
        int[][] stats = new int[m][5];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int score = 0, p = 0;
            /* 根据 ）、空格 分割答题字符串 */
            String[] q = answer[i].split("\\) ?");
            for (int j = 0; j < m; j++) {
                for (int indexA = 6, indexB = 3; indexA < question[j].length() ; ) {
                    // 这里多了一个半对的类型
                }
            }
        }
    }
}
