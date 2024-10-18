package pta.basic;

import java.util.Scanner;

/**
 * 1019 数字黑洞 (20 分)
 * 坑点：对于 "0001" 这样的数，要变为 1000 - 1 = 999
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1019 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        do {
            int max = max(n);
            int min = min(n);
            n = max - min;
            System.out.format("%04d - %04d = %04d%n", max, min, n);
            if (n == 0) {
                break;
            }
        } while (n != 6174);
    }

    private static int min(int n) {
        int[] cs = deal(n);
        int result = 0;
        for (int i = 0; i < cs.length; i++) {
            result = result * 10 + cs[i];
        }
        return result;
    }

    private static int max(int n) {
        int[] cs = deal(n);
        int result = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            result = result * 10 + cs[i];
        }
        return result;
    }

    private static int[] deal(int n) {
        int[] num = new int[] {0, 0, 0, 0};
        num[0] = n % 10;
        num[1] = n / 10 % 10;
        num[2] = n / 100 % 10;
        num[3] = n / 1000 % 10;

        for (int i = 0; i < num.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[index] > num[j]) {
                    index = j;
                }
            }
            if (num[i] != num[index]) {
                int temp = num[i];
                num[i] = num[index];
                num[index] = temp;
            }
        }
        return num;
    }
}
