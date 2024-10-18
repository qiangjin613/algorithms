package pta.basic;

import java.util.Scanner;

/**
 * 1091 N-自守数 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1091 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        // 对输入逐个检测
        while (m-- != 0){
            boolean flag = false;
            int k = in.nextInt();
            int len = (k + "").length();
            for (int j = 0; j < 10; j++) {
                int temp = k * k * j;
                if (temp % Math.pow(10, len)== k) {
                    System.out.println(j + " " + temp);
                    flag = true;
                    break;
                }
            }
            // 没有找到 N-自守数，输出 No
            if (!flag) {
                System.out.println("No");
            }
        }
    }
}
