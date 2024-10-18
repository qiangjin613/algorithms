package pta.basic;

import java.util.Scanner;

/**
 * 1031 查验身份证 (15 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1031 {
    public static void main(String[] args) {
        int[] weight = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] checkCode = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean allPassed = true;
        String idNumber;

        LOOP :
        while (n-- != 0) {
            idNumber = in.next();
            int count = 0;
            for (int i = 0; i < idNumber.length() - 1; i++) {
                if (!Character.isDigit(idNumber.charAt(i))) {
                    System.out.println(idNumber);
                    allPassed = false;
                    continue LOOP;
                }
                count += (idNumber.charAt(i) - '0') * weight[i];
            }
            if (checkCode[count % 11] != idNumber.charAt(idNumber.length() - 1)) {
                System.out.println(idNumber);
                allPassed = false;
            }
        }
        if (allPassed) {
            System.out.println("All passed");
        }
    }
}
