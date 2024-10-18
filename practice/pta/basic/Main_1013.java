package pta.basic;

import java.util.Scanner;

/**
 * 1013 数素数 (20 分)
 * 整体思想是：先获取素数表，再处理结果集
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        // 素数表：
        int maxNum = 500_000;
        boolean[] isPrime = new boolean[maxNum]; /* isPrime[i] == false 为素数 */
        for (int i = 2; i < maxNum; i++) {
            for (int j = 2; j * i < maxNum; j++) {
                if (!isPrime[i]) {
                    isPrime[i * j] = true;
                }
            }
        }
        // 输出第 [m, n] 个素数
        int sign = 0; /* 代表第 sign 个素数 */
        int cnt = 0; /* 用于处理每 10 个数字占 1 行的需求 */
        StringBuilder input = new StringBuilder();
        for (int i = 2; i < maxNum; i++) {
            if (!isPrime[i] && ++sign >= m) {
                input.append(i);
                cnt++;
                if (cnt % 10 == 0) {
                    System.out.println(input);
                    input.delete(0, input.length());
                } else if (cnt < n - m + 1){
                    input.append(" ");
                }
            }
            if (sign >= n) {
                if (input.length() > 0) {
                    System.out.print(input);
                }
                break;
            }
        }
    }
}
