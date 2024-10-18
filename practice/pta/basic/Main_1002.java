package pta.basic;

import java.util.Scanner;

/**
 * 1002 写出这个数 (20 分)
 * 技巧：使用 char 字符类型与整数的转换关系来查找每个数字的拼音
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1002 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        // 遍历每位求和
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }
        // 处理结果输出
        String[] result = new String[] {
                "ling", "yi", "er", "san", "si", "wu",
                "liu", "qi", "ba", "jiu", "shi"};
        String temp = sum + "";
        for (int i = 0; i < temp.length(); i++) {
            System.out.print(result[temp.charAt(i) - '0']);
            if (i < temp.length() - 1) {
                System.out.print(" ");
            }
        }
    }
}
