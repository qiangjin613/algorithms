package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 1049 数列的片段和 (20 分)
 * 题目类型：找规律
 * 坑点：浮点数在多次运算后是有误差的，把数值转换为整数再进行计算，避免误差
 *      （但在本题中，并没有指出输入的小数是多少为，所以采用网上大家的，同意放大 1000 倍再进行计算）
 */
public class Main_1049 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            st.nextToken();
            double temp = st.nval;
            sum += (long) (temp * 1000) * (n - i) * (i + 1);
        }
        System.out.format("%.2f", sum / 1000.0);
    }
}
