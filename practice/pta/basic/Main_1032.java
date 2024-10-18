package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1032 挖掘机技术哪家强 (20 分)
 * （17份，最后一个测试点超时）
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 学校编号从 1 开始递增，最大可取到 n
        int[] score = new int[n + 1];
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            int index = Integer.parseInt(temp[0]);
            score[index] += Integer.parseInt(temp[1]);
            if (score[maxIndex] < score[index]) {
                maxIndex = index;
            }
        }
        System.out.print(maxIndex + " " + score[maxIndex]);
    }
}
