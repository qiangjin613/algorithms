package pta._2024520;

import java.util.Scanner;

public class Solution_520_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        boolean flag = false;
        scanner.nextLine();
        for (int i = total; i > 0; i--) {
            String temp = scanner.nextLine();
            if (check(temp)) {
                System.out.println(temp);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Not interesting.");
        }
    }

    private static boolean check(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }
}
