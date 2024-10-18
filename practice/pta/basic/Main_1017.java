package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1017 A除以B (20 分)
 * 提示：会超时，多次提交可能 AC
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        String a = inputStr[0];
        int b = Integer.parseInt(inputStr[1]);
        // 指定一个初始大小，会稍微提高一点效率（减少动态分配的时间）
        StringBuilder result = new StringBuilder(a.length());
        int temp = a.charAt(0) - '0';
        // 对 a.length() == 1 进行特判，处理类似于 '3 5' 的输入样例，输出 '0 3'
        if (a.charAt(0) - '0' > b || a.length() == 1) {
            result.append(temp / b);
            temp %= b;
        }
        for (int i = 1; i < a.length(); i++) {
            temp = temp * 10 + (a.charAt(i) - '0');
            if (temp >= b) {
                result.append(temp / b);
                temp %= b;
            } else {
                result.append(0);
            }
        }
        // 输出结果
        System.out.print(result + " " + temp);
    }
}
