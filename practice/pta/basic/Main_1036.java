package pta.basic;

import java.util.Scanner;

/**
 * 1036 跟奥巴马一起编程 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1036 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char c = in.next().charAt(0);

        // 首行
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
        System.out.println();
        // 中间行
        for (int i = 0; i < (n + 1) / 2 - 2; i++) {
            StringBuilder tempStr = new StringBuilder(c + "");
            for (int j = 0; j < n - 2; j++) {
                tempStr.append(' ');
            }
            System.out.println(tempStr.append(c).toString());
        }
        // 尾行
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }
}
