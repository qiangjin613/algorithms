package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 1092 最好吃的月饼 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1092_超时 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        // 记录每种月饼的销售额
        int[] kind = new int[n];
        int max = 0;
        // 录入数据并找出销售额最多的值
        while (m-- != 0) {
            for (int i = 0; i < n; i++) {
                st.nextToken();
                kind[i] += (int) st.nval;
                if (max < kind[i]) {
                    max = kind[i];
                }
            }
        }
        // 查找输出最大销售额和月饼类别
        System.out.println(max);
        boolean flag = false;
        for (int i = 0; i < kind.length; i++) {
            if (kind[i] == max) {
                System.out.format("%s%d", flag ? " " : "", i + 1);
                flag = true;
            }
        }
    }
}
