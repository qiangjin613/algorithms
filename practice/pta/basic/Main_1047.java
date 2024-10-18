package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1047 编程团体赛 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stats = new int[1001];
        while (n-- != 0) {
            String[] teamStr = br.readLine().split(" ");
            int teamID = Integer.parseInt(teamStr[0].split("-")[0]);
            int score = Integer.parseInt(teamStr[1]);
            stats[teamID] += score;
        }
        int max = 0;
        for (int i = 0; i < stats.length; i++) {
            if (stats[max] < stats[i]) {
                max = i;
            }
        }
        System.out.print(max + " " + stats[max]);
    }
}
