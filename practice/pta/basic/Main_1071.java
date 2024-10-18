package pta.basic;

import java.util.Scanner;

/**
 * 1071 小赌怡情 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1071 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = in.nextInt();
        while (k-- != 0) {
            int[] oneGame = new int[4];
            for (int i = 0; i < oneGame.length; i++) {
                oneGame[i] = in.nextInt();
            }
            // 玩家下注超过持有的筹码量
            if (oneGame[2] > t) {
                System.out.println("Not enough tokens.  Total = " + t + ".");
                continue;
            }
            // 玩家赢/输
            if ((oneGame[1] == 1 && oneGame[0] < oneGame[3]) || (oneGame[1] == 0 && oneGame[0] > oneGame[3])) {
                t += oneGame[2];
                System.out.println("Win " + oneGame[2] + "!  Total = " + t + ".");
            } else {
                t -= oneGame[2];
                System.out.println("Lose " + oneGame[2] + ".  Total = " + t + ".");
            }
            // 玩家输光
            if (t <= 0) {
                System.out.println("Game Over.");
                break;
            }
        }
    }
}
