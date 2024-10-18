package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1018 锤子剪刀布 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1018_超时 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 按字母序排列，可用于结果输出 “如果解不唯一，则输出按字母序最小的解”
        String str = "BCJ";
        String[] input;
        int[] result = new int[3];
        // 用于统计甲、乙获胜次数最多的手势
        int[][] stats = new int[2][3];
        while (n-- != 0) {
            input = br.readLine().split(" ");
            if (input[0].equals(input[1])) {
                result[1]++;
                continue;
            }
            int indexA = str.indexOf(input[0]);
            int indexB = str.indexOf(input[1]);
            if (indexA - indexB == -1 || indexA - indexB == 2) {
                result[0]++;
                stats[0][indexA]++;
            } else {
                result[2]++;
                stats[1][indexB]++;
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        System.out.println(result[2] + " " + result[1] + " " + result[0]);
        // 在查找甲、乙获胜次数最多的手势
        for (int i = 0; i < 2; i++) {
            int maxIndex = 0;
            for (int j = 1; j < 3; j++) {
                if (stats[i][maxIndex] < stats[i][j]) {
                    maxIndex = j;
                }
            }
            System.out.format("%s%s", i == 0 ? "" : " ", str.charAt(maxIndex));
        }
    }
}
