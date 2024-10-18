package pta.basic;

import java.util.Scanner;

/**
 * 1037 在霍格沃茨找零钱 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1037 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String p = in.next();
        String a = in.next();
        int totalP = transform(p);
        int totalA = transform(a);
        int temp = totalA - totalP;
        if (temp < 0) {
            System.out.print("-");
            temp = -temp;
        }
        int galleon = temp / (17 * 29);
        temp %= (17 * 29);
        int sickle = temp / 29;
        temp %= 29;
        System.out.format("%d.%d.%d", galleon, sickle, temp);
    }
    public static int transform(String s) {
        String[] temp = s.split("\\.");
        return Integer.parseInt(temp[0]) * 17 * 29 + Integer.parseInt(temp[1]) * 29 + Integer.parseInt(temp[2]);
    }
}

// 1 加隆（Galleon） = 17 西可（Sickle）
// 1 西可（Sickle） = 29 纳特（Knut）