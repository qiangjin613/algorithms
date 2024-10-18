package pta.basic;

import java.util.Scanner;

/**
 * 1010 一元多项式求导 (25 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1010 {
    /**
     * 这个是测试点 1、2 跑不通的版本
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split(" ");
        boolean flag = false;
        for (int i = 0; i < data.length; i += 2) {
            int a = Integer.parseInt(data[i]);
            int b = Integer.parseInt(data[i + 1]);
            if (b != 0) {
                System.out.format("%s%d %d", flag ? " " : "", a * b, b - 1);
                flag = true;
            }
        }
        if (!flag) {
            System.out.print("0 0");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        while (in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            if (b != 0) {
                System.out.format("%s%d %d", flag ? " " : "", a * b, b - 1);
                flag = true;
            }
        }
        if (!flag) {
            System.out.print("0 0");
        }
    }
}
