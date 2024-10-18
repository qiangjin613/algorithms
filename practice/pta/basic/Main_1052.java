package pta.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1052 卖个萌 (20 分)
 * 注：4分（测试点 0、1 未通过）
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1052 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 获取可选符号集
        List<String> hand = dealLine(in.nextLine());
        List<String> eye = dealLine(in.nextLine());
        List<String> mouth = dealLine(in.nextLine());
        // 获取用户输入参数
        int n = Integer.parseInt(in.nextLine());
        while (n-- != 0) {
            // 获取用户的符号选择：1 1 2 2 2
            String[] strs = in.nextLine().split(" ");
            int[] input = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                input[i] = Integer.parseInt(strs[i]);
            }
            if (input[0] < 1 || input[0] > hand.size()
                    || input[1] < 1 || input[1] > eye.size()
                    || input[2] < 1 || input[2] > mouth.size()
                    || input[3] < 1 || input[3] > eye.size()
                    || input[4] < 1 || input[4] > hand.size()) {
                System.out.println("Are you kidding me? @\\/@");
            } else {
                System.out.format("%s(%s%s%s)%s%n",
                        hand.get(input[0] - 1), eye.get(input[1] - 1),
                        mouth.get(input[2] - 1), eye.get(input[3] - 1),
                        hand.get(input[4] - 1));
            }
        }
    }

    public static List<String> dealLine(String str) {
        List<String> result = new ArrayList<>(10);
        StringBuilder temp = new StringBuilder();
        boolean sign = false;
        for (int i = 0; i < str.length(); i++) {
            // 在这里遇见 "...[[[jk].." 这样的情况，也是从 'j' 开始获取
            if ('[' == str.charAt(i)) {
                sign = true;
            }
            // 添加 '&& sign' 是为了应对 "..]].." 这样的情况，存入一个空的表情到 List 里
            else if (']' == str.charAt(i) && sign) {
                sign = false;
                result.add(temp.toString());
                temp.delete(0, temp.length());
            } else if (sign) {
                temp.append(str.charAt(i));
            }
        }
        return result;
    }
}
