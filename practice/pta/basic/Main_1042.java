package pta.basic;

import java.util.Scanner;

/**
 * 1042 字符统计 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1042 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inptStr = in.nextLine();
        // 26 个字母对应的结果数组
        int[] stats = new int[26];
        // 忽略大小写统计字母数
        for (int i = 0; i < inptStr.length(); i++) {
            char c = inptStr.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stats[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                stats[c - 'A']++;
            }
        }
        // 根据统计结果得出最大值
        int max = 0;
        for (int i = 0; i < stats.length; i++) {
            if (stats[i] > stats[max]) {
                max = i;
            }
        }
        System.out.format("%c %d", max + 'a', stats[max]);
    }
}
