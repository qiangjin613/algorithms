package pta.basic;

import java.util.Scanner;

/**
 * 1067 试密码 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1067 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        String pwd = input[0];
        int time = Integer.parseInt(input[1]);
        String tempPwd;
        while (time-- != 0) {
            tempPwd = in.nextLine();
            if (tempPwd.equals(pwd)) {
                System.out.print("Welcome in");
                return;
            } else if ("#".equals(tempPwd)) {
                return;
            } else {
                    System.out.println("Wrong password: " + tempPwd);
            }
        }
        System.out.print("Account locked");
    }
}
