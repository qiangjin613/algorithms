package pta.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 1089 狼人杀-简单版 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1089 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        /* i、j 指向的是狼 */
        for (int i = 1; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                /* sign[i] = -1 为狼 */
                int[] sign = new int[n + 1];
                Arrays.fill(sign, 1);
                sign[i] = sign[j] = -1;
                List<Integer> lie = new ArrayList<>(16);
                /* 检测 k 是否说谎 */
                for (int k = 1; k < a.length; k++) {
                    if (a[k] * sign[Math.abs(a[k])] < 0) {
                        lie.add(k);
                    }
                }
                if (lie.size() == 2 && (sign[lie.get(0)] + sign[lie.get(1)] == 0)) {
                    System.out.print(i + " " + j);
                    return;
                }
            }
        }
        System.out.print("No Solution");
    }
}
