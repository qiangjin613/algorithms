package pta.basic;

import java.util.Scanner;

/**
 * 1046 划拳 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1046 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] note = new int[4];
        int countA = 0, countB = 0;
        while (n-- != 0) {
            for (int i = 0; i < 4; i++) {
                note[i] = in.nextInt();
            }
            if (note[1] == note[3]) {
                continue;
            }
            // 甲赢
            else if (note[1] == note[0] + note[2]) {
                countB ++;
            }
            // 乙赢
            else if (note[3] == note[0] + note[2]) {
                countA ++;
            }
        }
        System.out.print(countA + " " + countB);
    }
}
