package pta.basic;

import java.util.Scanner;

/**
 * 1009 说反话 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder output = new StringBuilder(input.length());
        StringBuilder temp = new StringBuilder();
        for (int i = 0, len = input.length(); i < len; i++) {
            char c = input.charAt(i);
            if (c != ' ') {
                temp.append(c);
            } else {
                if (output.length() != 0) {
                    output.insert(0, " ");
                }
                output.insert(0, temp);
                temp.delete(0, temp.length());
            }
        }
        if (output.length() != 0) {
            output.insert(0, " ");
        }
        output.insert(0, temp);
        System.out.print(output);
    }

    public static void main02(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String[] words = str.split(" ");

        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0 ; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        System.out.print(result);
    }
}
