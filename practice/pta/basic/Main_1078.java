package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1078 字符串压缩与解压 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sign = br.readLine();
        String input = br.readLine();
        StringBuilder output = new StringBuilder();
        /* 压缩 */
        if ("C".equals(sign)) {
            int i = 0, len = input.length();
            while (i < len) {
                char temp = input.charAt(i);
                int j = i + 1;
                while (j < len && temp == input.charAt(j)) {
                    j++;
                }
                if (j - i > 1) {
                    output.append(j - i);
                }
                output.append(input.charAt(i));
                i = j;
            }
        }
        /* 解压 */
        else if ("D".equals(sign)) {
            for (int i = 0, len = input.length(); i < len; i++) {
                int temp = 0;
                while (i < len && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    temp = temp * 10 + (input.charAt(i) - '0');
                    i++;
                }
                char c = input.charAt(i);
                if (temp == 0) {
                    output.append(c);
                }
                for (int p = 0; p < temp; p++) {
                    output.append(c);
                }
            }
        }
        System.out.print(output);
    }
}
