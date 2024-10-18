package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

/**
 * 1068 万绿丛中一点红 (20 分)
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Main_1068 {
    public static void main(String[] args) throws IOException {
        // 录入数据：
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int m = (int) st.nval;
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int tol = (int) st.nval;
        int[][] map = new int[n][m];
        /* 用于标记该像素点出现的次数 */
        Map<Integer, Integer> sign = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                st.nextToken();
                map[i][j] = (int) st.nval;
                Integer cnt = sign.get(map[i][j]);
                if (cnt == null) {
                    sign.put(map[i][j], 1);
                } else {
                    sign.replace(map[i][j], cnt + 1);
                }
            }
        }
        // 查找“一点红”：
        int x = 0, y = 0, point = 0;
        int stats = 0;
        LOOP:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /* 对独一无二颜色的那个像素点进行判断 */
                if (sign.get(map[i][j]) == 1) {
                    // 与周围像素点比较：
                    boolean isTrue = true;
                    for (int i1 = i - 1; i1 <= i + 1; i1++) {
                        for (int j1 = j - 1; j1 <= j + 1; j1++) {
                            /* 排除自己 */
                            if ((i == i1 && j == j1)) {
                                continue;
                            }
                            /* 对合法的范围进行比较 */
                            if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < m) {
                                int temp = map[i][j] - map[i1][j1];
                                temp = temp < 0? -temp: temp;
                                if (temp <= tol) {
                                    isTrue = false;
                                }
                            }
                        }
                    }
                    if (isTrue) {
                        point = map[i][j];
                        x = j;
                        y = i;
                        stats++;
                    }
                }
                if (stats > 1) {
                    break LOOP;
                }
            }
        }
        // 输出结果：
        if (stats > 1) {
            System.out.print("Not Unique");
        } else if (stats == 0) {
            System.out.print("Not Exist");
        } else {
            System.out.format("(%d, %d): %d", x + 1, y + 1, point);
        }
    }

    /**
     * 还有一种处理周围数据的一种方法：先将可能踩到的点写好，然后进行踩点判断
     * 这种方法不同于上面的寻找 i、j 变化的规律；
     * 这里可以当前 (i,j) 为基准，向周围移动多少单位
     */
    static int dir[][] = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    public static boolean judge(int i, int j) {
        for (int k = 0; k < 8; k++) {
            int tx = i + dir[k][0];
            int ty = j + dir[k][1];
            // deal ...
        }
        return true;
    }
}
