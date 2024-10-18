package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1033 旧键盘打字 (20 分)
 * 技巧：本题中的字符串内容都可以使用 ASCII 表示，故可实现一个 boolean 的查找表
 * 利用输入数据（坏键盘）的 ASCII 范围
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1033 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // badKey[i] = true 表示坏键
        boolean[] badKey = new boolean[128];
        for (char c : br.readLine().toCharArray()) {
            badKey[c] = true;
            if (c >= 'A' && c <= 'Z') {
                badKey[c + 32] = true;
            }
        }
        char[] intput = br.readLine().toCharArray();
        StringBuilder output = new StringBuilder();
        for (char c : intput) {
            // 处理大写字符
            if (badKey['+'] && c >= 'A' && c <= 'Z') {
                continue;
            }
            // 如果该键没有坏，就加入到输出中：
            if (!badKey[c]) {
                output.append(c);
            }
        }
        System.out.print(output);
    }


    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] badKey = br.readLine().toCharArray();
        // upperCase = true 代表有大写字符
        boolean upperCase = true;
        for (char c : badKey) {
            if (c == '+') {
                upperCase = false;
                break;
            }
        }
        String input = br.readLine();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            // 处理无法打印的大写字母
            if (!upperCase && temp >= 'A' && temp <= 'Z') {
                continue;
            }
            // flag = false 为该键没有坏掉
            boolean flag = false;
            for (char c : badKey) {
                if (c == temp) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                output.append(temp);
            }
        }
        System.out.print(output);
    }
}
