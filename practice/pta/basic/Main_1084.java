package pta.basic;

import java.util.Scanner;

/**
 * 1084 外观数列 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1084 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder d = new StringBuilder().append(in.nextInt());
        int n = in.nextInt();
        while (n-- > 1) {
            StringBuilder temp = new StringBuilder(16);
            int j;
            for (int i = 0; i < d.length(); i = j) {
                for (j = i; j < d.length() && d.charAt(j) == d.charAt(i); j++);
                temp.append(d.charAt(i)).append(j - i);
            }
            d = temp;
        }
        System.out.print(d);
    }
}
