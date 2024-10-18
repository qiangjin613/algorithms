package pta.basic;

import java.util.Scanner;

/**
 * 1006 换个格式输出整数 (15分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 分离数字
        int[] ns = new int[3];
        int cnt = 0;
        do {
            ns[cnt ++] = n % 10;
            n /= 10;
        } while (n != 0);

        // 输出结果
        for (int i = 0; i < ns[2]; i++) {
            System.out.print("B");
        }
        for (int i = 0; i < ns[1]; i++) {
            System.out.print("S");
        }
        for (int i = 0; i < ns[0]; i++) {
            System.out.print(i + 1);
        }
    }
}

/**
 * 技巧1：String -> char[]: 使用 toCharArray() 将字符串转换为 char[] 进行操作
 */
class Main_1006_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strNum = in.next();
        char[] numbers = strNum.toCharArray();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i] - '0'; j++) {
                if (numbers.length - i == 3) { // 百位
                    result.append('B');
                }
                else if (numbers.length - i == 2) { // 十位
                    result.append('S');
                }
                else if (numbers.length - i == 1) { // 个位
                    result.append(j + 1);
                }
            }
        }

        System.out.print(result);
    }
}