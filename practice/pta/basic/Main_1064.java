package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 1064 朋友数 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1064 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        boolean[] sign = new boolean[50];
        int cnt = 0;
        while (n-- != 0) {
            st.nextToken();
            String temp = (int) st.nval + "";
            int friendNo = 0;
            for (int i = 0; i < temp.length(); i++) {
                friendNo += temp.charAt(i) - '0';
            }
            if (!sign[friendNo]) {
                sign[friendNo] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
        if (cnt != 0) {
            boolean flag = false;
            for (int i = 0; i < sign.length; i++) {
                if (sign[i]) {
                    System.out.format("%s%d", flag ? " " : "", i);
                    flag = true;
                }
            }
        }
    }
}
