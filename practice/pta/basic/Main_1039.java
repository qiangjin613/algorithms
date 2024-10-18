package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1039 到底买不买 (20 分)
 * 技巧：标记再统计
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strA = br.readLine();
        String strB = br.readLine();
        int lenA = strA.length(), lenB = strB.length();

        int[] signA = new int[150];
        int[] signB = new int[150];
        for (int i = 0; i < lenA || i < lenB; i++) {
            if (i < lenA) {
                signA[strA.charAt(i)]++;
            }
            if (i < lenB) {
                signB[strB.charAt(i)]++;
            }
        }
        boolean flag = true;
        int lack = 0;
        for (int i = 0; i < 150; i++) {
            if (signB[i] != 0 && signB[i] > signA[i]) {
                /* 缺少珠子 */
                flag = false;
                lack += signB[i] - signA[i];
            }
        }
        if (flag) {
            System.out.print("Yes " + (lenA - lenB));
        } else {
            System.out.print("No " + lack);
        }
    }
}
