package pta.basic;

import java.util.Scanner;

/**
 * 1094 谷歌的招聘 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1094 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int k = in.nextInt();
        String n = in.next();
        boolean flag = false;
        for (int i = k; i <= n.length(); i++) {
            String temp = n.substring(i - k, i);
            int p = Integer.parseInt(temp);
            if (isPrime(p)) {
                System.out.print(temp);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.print("404");
        }
    }
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
