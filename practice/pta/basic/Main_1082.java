package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1082 射击比赛 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String newbie = "", champion = "";
        int min = 10001, max = -1;
        while (n-- != 0) {
            String[] row = br.readLine().split(" ");
            int x = Integer.parseInt(row[1]);
            int y = Integer.parseInt(row[2]);
            int d = x * x + y * y;
            if (d > max) {
                max = d;
                champion = row[0];
            }
            if (d < min) {
                min = d;
                newbie = row[0];
            }
        }
        System.out.print(newbie + " " + champion);
    }
}
