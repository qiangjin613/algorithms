package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1066 图像过滤 (15 分)
 * 最后的测试点超时【在线求解】
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int m = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);
        int a = Integer.parseInt(temp[2]);
        int b = Integer.parseInt(temp[3]);
        int x = Integer.parseInt(temp[4]);

        for (int i = 0; i < m; i++) {
            String[] pixel = br.readLine().split(" ");
            for (int j = 0; j < pixel.length; j++) {
                int point = Integer.parseInt(pixel[j]);
                if (point >= a && point <= b) {
                    System.out.printf("%03d", x);
                } else {
                    System.out.printf("%03d", point);
                }
                if (j < pixel.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
