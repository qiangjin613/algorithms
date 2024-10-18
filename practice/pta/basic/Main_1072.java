package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1072 开学寄语 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] batch = br.readLine().split(" ");
        int n = Integer.parseInt(batch[0]);
        int m = Integer.parseInt(batch[1]);
        String[] contraband = br.readLine().split(" ");
        int[] count = new int[2];
        while (n-- != 0) {
            String[] stuItems = br.readLine().split(" ");
            int k = Integer.parseInt(stuItems[1]);
            boolean carry = false;
            StringBuilder output = new StringBuilder(stuItems[0]).append(":");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < k; j++) {
                    if (contraband[i].equals(stuItems[2 + j])) {
                        output.append(" ").append(stuItems[2 + j]);
                        carry = true;
                        count[1]++;
                    }
                }
            }
            if (carry) {
                System.out.println(output);
                count[0]++;
            }
        }
        System.out.print(count[0] + " " + count[1]);
    }
}
