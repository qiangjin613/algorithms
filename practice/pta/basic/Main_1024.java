package pta.basic;

import java.util.Scanner;

/**
 * 1024 科学计数法 (20 分)
 * 提示：输出时会运行超时
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1024 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input.charAt(0) == '-') {
            System.out.print("-");
        }
        /* 待输出的数 */
        StringBuilder num = new StringBuilder(input.length());
        int i = 1;
        while (input.charAt(i) != 'E') {
            char c = input.charAt(i++);
            if (c == '.') {
                continue;
            }
            num.append(c);
        }
        i++;
        /* 指数部分是否为负数：sign = false 是负数 */
        boolean sign = input.charAt(i++) == '+';
        /* 指数 */
        int e = 0;
        while (i < input.length()) {
            e = e * 10 + (input.charAt(i++) - '0');
        }
        // 输出：
        StringBuilder output = new StringBuilder(999);
        if (sign) {
            // 1.23345E+2 --> 123.345
            int k = 0;
            for (int len = num.length(); k < len;k++) {
                if (k == e + 1) {
                    output.append(".");
                }
                output.append(num.charAt(k));
            }
            for (; k <= e; k++) {
                output.append("0");
            }
        } else {
            // 1.23345E-1 --> 0.1
            output.append("0.");
            for (int k = 0; k < e - 1; k++) {
                output.append("0");
            }
            output.append(num);
        }
        System.out.println(output);
    }
}
