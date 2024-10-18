package pta.basic;

import java.util.Scanner;

/**
 * 1076 Wifi密码 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1076 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // 过滤掉 nextXxx() 留下的分隔符（空格、回车等）
        while (n-- != 0) {
            String ansStr = in.nextLine();
            int index = ansStr.indexOf("T");
            char c = ansStr.charAt(index - 2);
            System.out.print(c - 'A' + 1);
        }
    }
}
