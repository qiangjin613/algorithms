package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1093 字符串A+B (20 分)
 * 先拼接输入的字符串 A、B 然后标记是否被使用过
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().concat(br.readLine());
        boolean[] flag = new boolean[150];
        StringBuilder output = new StringBuilder();
        for (int i = 0, len = input.length(); i < len; i++) {
            char c = input.charAt(i);
            if (!flag[c]) {
                output.append(c);
            }
            flag[c] = true;
        }
        System.out.print(output);
    }
}
