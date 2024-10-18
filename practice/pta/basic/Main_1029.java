package pta.basic;

import java.util.Scanner;

/**
 * 1029 旧键盘 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1029 {
    /**
     * 以实际输入的键为基准，再从将要输入的键里面寻找，若不同且没有被输出的情况下输出该键值
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String rawStr = in.nextLine();
        String actualStr = in.nextLine();
        /* badKey[i] = true 代表该键已坏 */
        boolean[] badKey = new boolean[150];
        int j = 0;
        // 1.标记没有坏掉的键
        for (int i = 0, len = actualStr.length(); i < len; i++, j++) {
            char c = actualStr.charAt(i);
            badKey[c] = true;
            /* 转换大写 */
            if (c >= 'a' && c <= 'z') {
                badKey[c - 32] = true;
            }
        }
        // 2.扫描输出坏键
        /* sign[i] = true 代表该值已经被输出过 */
        boolean[] sign = new boolean[150];
        for (int i = 0, len = rawStr.length(); i < len; i++) {
            char c = rawStr.charAt(i);
            /* 转换大写 */
            if (c >= 'a' && c <= 'z') {
                c -= 32;
            }
            if (!badKey[c] && !sign[c]) {
                System.out.print(c);
                sign[c] = true;
            }
        }
    }
}
