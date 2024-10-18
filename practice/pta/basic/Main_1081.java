package pta.basic;

import java.util.Scanner;

/**
 * 1081 检查密码 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1081 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-- != 0) {
            // 这里有一个测试点：密码的输入以回车结束，类似于 'fsdf 3278.fds d' 的密码输入，使用 in.next() 是不合理的
            String password = in.nextLine();
            int len = password.length();
            // 密码长度校验
            if (len < 6) {
                System.out.println("Your password is tai duan le.");
                continue;
            }
            // 密码合法性校验
            boolean zimu = false, shuzi = false, tailuan = false;
            for (int i = 0; i < len; i++) {
                char c = password.charAt(i);
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    zimu = true;
                } else if (c >= '0' && c <= '9') {
                    shuzi = true;
                } else if (c != '.') {
                    tailuan = true;
                    break;
                }
            }
            // 输出结果
            if (tailuan) {
                System.out.println("Your password is tai luan le.");
            } else if (!zimu) {
                System.out.println("Your password needs zi mu.");
            } else if (!shuzi) {
                System.out.println("Your password needs shu zi.");
            } else {
                System.out.println("Your password is wan mei.");
            }
        }
    }
}
