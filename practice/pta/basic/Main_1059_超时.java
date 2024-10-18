package pta.basic;

import java.io.*;

/**
 * 1059 C语言竞赛 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1059_超时 {
    /* 最大参赛数 */
    public static final int MAX_VALUE = 10000;
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        /* stu[i] 代表学号为 i 的学生的排名 */
        int[] stu = new int[MAX_VALUE];
        for (int i = 1; i <= n; i++) {
            st.nextToken();
            stu[(int) st.nval] = i;
        }

        /* prime[i] == false 为素数 */
        boolean[] prime = new boolean[MAX_VALUE];
        for (int i = 2; i < MAX_VALUE; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j < MAX_VALUE; j += i) {
                    prime[j] = true;
                }
            }
        }

        /* isGet[i] == false 为未领状态 */
        boolean[] isGet = new boolean[MAX_VALUE];
        st.nextToken();
        int k = (int) st.nval;
        while (k-- != 0) {
            st.nextToken();
            int sid = (int) st.nval;
            int number = stu[sid];
            if (number == 0) {
                System.out.format("%04d: Are you kidding?%n", sid);
            } else if (isGet[number]) {
                System.out.format("%04d: Checked%n", sid);
            } else if (number == 1) {
                System.out.format("%04d: Mystery Award%n", sid);
            } else if (!prime[number]) {
                System.out.format("%04d: Minion%n", sid);
            } else {
                System.out.format("%04d: Chocolate%n", sid);
            }
            isGet[number] = true;
        }
    }
}
