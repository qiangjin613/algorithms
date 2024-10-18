package pta.basic;

import java.util.Scanner;

/**
 * 1003 我要通过！ (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1003 {

    /**
     * 方法 1：直接对 P、T 间的 A 的数量进行统计
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- != 0) {
            String testStr = in.next();
            int p = 0, pLeft = 0, ptInner = 0, t = 0, tRight = 0;
            boolean isTrue = true;
            for (int i = 0; i < testStr.length() && isTrue; i++) {
                char c = testStr.charAt(i);
                // 排除除 P、A、T 之外的字符：
                if (c != 'P' && c != 'A' && c != 'T') {
                    isTrue = false;
                    break;
                }
                // 统计被 P、T 分开的 A 的数量：
                switch (c) {
                    case 'P': p++; break;
                    case 'T': t++; break;
                    default:
                        if (p == 0) {
                            pLeft++;
                        } else if (t == 0) {
                            ptInner++;
                        } else {
                            tRight++;
                        }
                }
                // 如果 P、T 之间有一个统计结果大于 1，则为错误答案
                if (p * t > 2) {
                    isTrue = false;
                    break;
                }
            }
            // 当且仅当 P、T 数量为 1，P、T 间 "A" 的数量不为零，并且满足推测公式的时候为正确答案：
            if (p * t == 1 && ptInner != 0 && pLeft * ptInner == tRight && isTrue) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    /**
     * 方法2：从 P、T 的位置计算 "A" 的数量
     */
    public static void main_2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- != 0) {
            String testStr = in.next();
            int indexP = -1, indexT = -1, p = 0, t = 0;
            boolean isTrue = true;
            for (int i = 0; i < testStr.length() && isTrue; i++) {
                char c = testStr.charAt(i);
                if (c != 'P' && c != 'A' && c != 'T') {
                    isTrue = false;
                    break;
                }
                switch (c) {
                    case 'P':
                        p++;
                        indexP = i;
                        break;
                    case 'T':
                        t++;
                        indexT = i;
                        break;
                }
            }
            // P、T 的数量仅为 1 个，并且满足推理公式时答案正确：
            if (p == 1 && t == 1
                    && indexT - indexP > 1
                    && indexP * (indexT - indexP - 1) == testStr.length() - indexT -1
                    && isTrue) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
