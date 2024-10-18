package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1061 判断题 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1061 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmStr = br.readLine().split(" ");
        int n = Integer.parseInt(nmStr[0]);
        int m = Integer.parseInt(nmStr[1]);
        // 录入每题权重
        int[] weight = new int[m];
        String[] weightStr = br.readLine().split(" ");
        for (int i = 0; i < weightStr.length; i++) {
            weight[i] = Integer.parseInt(weightStr[i]);
        }
        // 录入正确答案
        String[] ans = br.readLine().split(" ");
        // 录入学生答案并处理
        int[] results = new int[n];
        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < temp.length; j++) {
                if (ans[j].equals(temp[j])) {
                    results[i] += weight[j];
                }
            }
        }
        // 输出结果
        for (int result : results) {
            System.out.println(result);
        }
    }
}
