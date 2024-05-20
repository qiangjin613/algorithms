package pta._2024520;

import java.io.IOException;
import java.util.Scanner;

public class Solution_520_2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x % 2 == 0 && y % 2 == 0) {
            System.out.printf("%d %d ^_^!", x, y);
        } else {
            System.out.printf("%d %d -_-", x, y);
        }
    }
}
