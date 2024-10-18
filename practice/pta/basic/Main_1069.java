package pta.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 1069 微博转发抽奖 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1069 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int s = in.nextInt();
        String[] friend = new String[m];
        Set<String> set = new HashSet<>(s);
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            friend[i] = in.next();
            if (i + 1 == s) {
                if (!set.contains(friend[i])) {
                    System.out.println(friend[i]);
                    set.add(friend[i]);
                    s += n;
                    flag = true;
                } else {
                    s++;
                }
            }
        }
        if (!flag) {
            System.out.print("Keep going...");
        }
    }
}
