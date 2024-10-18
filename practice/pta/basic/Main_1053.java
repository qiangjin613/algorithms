package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 1053 住房空置率 (20 分)
 */
public class Main_1053 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        /* 居民数 */
        st.nextToken();
        int n = (int) st.nval;
        /* 低电量阈值 */
        st.nextToken();
        double e = st.nval;
        /* 观察期（天数）阈值 */
        st.nextToken();
        int d = (int) st.nval;
        int maybe = 0, must = 0;
        for (int i = 0; i < n; i++) {
            /* 观察期 */
            st.nextToken();
            int k = (int) st.nval;
            int cnt = 0;
            for (int j = 1; j <= k; j++) {
                st.nextToken();
                if (st.nval < e) {
                    cnt++;
                }
            }
            if (k > d && cnt > k / 2) {
                must++;
            } else if (cnt > k / 2) {
                maybe++;
            }
        }
        System.out.format("%.1f%% %.1f%%", maybe*1.0/n*100, must*1.0/n*100);
    }
}
