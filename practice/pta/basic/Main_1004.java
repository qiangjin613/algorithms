package pta.basic;

import java.util.Scanner;

/**
 * 1004 成绩排名 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1004 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String minName = "", maxName = "";
        String minId = "", maxId = "";
        int minScore = 100, maxScore = 0;
        for (int i = 0; i < n; i++) {
            String name = in.next();
            String id = in.next();
            int score = in.nextInt();
            if (score > maxScore) {
                maxScore = score;
                maxId = id;
                maxName = name;
            }
            if (score < minScore) {
                minScore = score;
                minId = id;
                minName = name;
            }
        }
        System.out.println(maxName + " " + maxId);
        System.out.print(minName + " " + minId);
    }
}
