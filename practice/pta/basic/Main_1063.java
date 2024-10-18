package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 1063 计算谱半径 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1063 {
    /**
     * 使用 StreamTokenizer 比 BufferedReader 要快一些
     */
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        int max = 0;
        while (n-- != 0) {
            st.nextToken();
            int a = (int) st.nval;
            st.nextToken();
            int b = (int) st.nval;
            int temp = a * a + b * b;
            if (temp > max) {
                max = temp;
            }
        }
        System.out.format("%.2f", Math.sqrt(max * 1.0));
    }

    /**
     * 使用 BufferedReader 会超时
     */
    public static void main02(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        String[] input;
        while (n-- != 0) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int temp = a * a + b * b;
            if (temp > max) {
                max = temp;
            }
        }
        System.out.format("%.2f", Math.sqrt(max * 1.0));
    }
}
