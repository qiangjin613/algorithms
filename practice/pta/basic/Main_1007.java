package pta.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1007 素数对猜想 (20 分)
 * 提示：对于可能用到大批素数的情况，打表法是一个很好的选择
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 使用“打表法”预存可能用到的素数数据
        boolean[] isPrimes = new boolean[n + 1];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i <= n; i++) {
            if (isPrimes[i]) {
                for (int k = 2; i * k <= n; k++) {
                    isPrimes[i * k] = false;
                }
            }
        }
        int[] primes = new int[isPrimes.length];
        int primesLen = 0;
        for (int i = 1; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                primes[primesLen++] = i;
            }
        }
        // 统计最终结果
        int count = 0;
        for (int i = 1; i < primesLen; i++) {
            if (primes[i] - primes[i - 1] == 2) {
                count++;
            }
        }
        System.out.print(count);
    }
}
