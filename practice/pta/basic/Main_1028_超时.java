package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1028 人口普查 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1028_超时 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // eldest 最年长的，youngest 最年轻的
        String[] eldest = new String[2];
        String[] youngest = new String[2];
        eldest[1] = "2014/09/06";
        youngest[1] = "1814/09/06";
        int cnt = 0;

        String[] input;
        while (n-- != 0) {
            input = br.readLine().split(" ");
            // 忽略掉不合法的生日输入
            if (input[1].compareTo("1814/09/06") < 0 || input[1].compareTo("2014/09/06") > 0) {
                continue;
            }
            cnt++;
            if (input[1].compareTo(eldest[1]) < 0) {
                eldest[0] = input[0];
                eldest[1] = input[1];
            }
            if (input[1].compareTo(youngest[1]) > 0) {
                youngest[0] = input[0];
                youngest[1] = input[1];
            }
        }
        System.out.print(cnt);
        if (cnt > 0) {
            System.out.print(" " + eldest[0] + " " + youngest[0]);
        }
    }
}
