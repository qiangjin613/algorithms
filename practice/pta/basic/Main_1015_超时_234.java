package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Formatter;

/**
 * 1015 德才论 (25 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1015_超时_234 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int l = (int) st.nval;
        st.nextToken();
        int h = (int) st.nval;

        Student[] stus = new Student[n];
        int cnt = 0;
        while (n-- != 0) {
            st.nextToken();
            int id = (int) st.nval;
            st.nextToken();
            int scoreA = (int) st.nval;
            st.nextToken();
            int scoreB = (int) st.nval;
            if (scoreA < l || scoreB < l) {
                continue;
            }
            int level = 4;
            if (scoreA >= h && scoreB >= h) {
                level = 1;
            } else if (scoreA >= h) {
                level = 2;
            } else if (scoreA >= scoreB) {
                level = 3;
            }
            stus[cnt++] = new Student(id, scoreA, scoreB, level);
        }

        Arrays.sort(stus, 0, cnt, (s1, s2) -> {
                int sum1 = s1.scoreA + s1.scoreB;
                int sum2 = s2.scoreA + s2.scoreB;
                if (s1.level != s2.level) {
                    return s1.level - s2.level;
                } else if (sum1 != sum2) {
                    return sum2 - sum1;
                } else if (s1.scoreA != s2.scoreA) {
                    return s2.scoreA - s1.scoreA;
                } else if (s1.id != s2.id) {
                    return s1.id - s2.id;
                }
                return 0;
        });

        System.out.println(cnt);
        if (cnt != 0) {
            for (int i = 0; i < cnt; i++) {
                System.out.println(stus[i].id + " " + stus[i].scoreA + " " + stus[i].scoreB);
            }
        }

        /* 依旧超时 */
//        Formatter formatter = new Formatter(new StringBuilder());
//        if (cnt != 0) {
//            for (int i = 0; i < cnt; i++) {
//                formatter.format("%d %d %d\n", stus[i].id, stus[i].scoreA, stus[i].scoreB);
//            }
//            System.out.print(formatter);
//        }
    }

    static class Student {
        int id;
        int scoreA;
        int scoreB;
        int level;

        public Student(int id, int scoreA, int scoreB, int level) {
            this.id = id;
            this.scoreA = scoreA;
            this.scoreB = scoreB;
            this.level = level;
        }
    }
}
