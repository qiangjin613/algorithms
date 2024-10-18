package pta.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1041 考试座位号 (15 分)
 * Main_1041、Main_1041_2 因 Scanner 太慢了，所以超时
 * Main_1041_3 使用了 BufferedReader，可以稍微快一点，AC
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
class ExamInfo {
    // 准考证号
    long zkzNo;
    // 机试座位号
    int jsNo;
    // 考试座位号
    int ksNo;

    public ExamInfo(long zkzNo, int jsNo, int ksNo) {
        this.zkzNo = zkzNo;
        this.jsNo = jsNo;
        this.ksNo = ksNo;
    }

    public void print() {
        System.out.println(zkzNo + " " + ksNo);
    }
}

public class Main_1041 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, ExamInfo> stuMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            long zkzNo = in.nextLong();
            int jsNo = in.nextInt();
            int ksNo = in.nextInt();
            stuMap.put(jsNo, new ExamInfo(zkzNo, jsNo, ksNo));
        }
        int m = in.nextInt();
        while (m-- != 0) {
            int jsNo = in.nextInt();
            stuMap.get(jsNo).print();
        }
    }
}

class Main_1041_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ExamInfo[] examInfos = new ExamInfo[n + 1];
        for (int i = 0; i < n; i++) {
            long zkzNo = in.nextLong();
            int jsNo = in.nextInt();
            int ksNo = in.nextInt();
            examInfos[jsNo] = new ExamInfo(zkzNo, jsNo, ksNo);
        }
        int m = in.nextInt();
        while (m-- != 0) {
            int jsNo = in.nextInt();
            examInfos[jsNo].print();
        }
    }
}

/**
 * AC
 */
class Main_1041_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ExamInfo[] examInfos = new ExamInfo[n + 1];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            long zkzNo = Long.parseLong(temp[0]);
            int jsNo = Integer.parseInt(temp[1]);
            int ksNo = Integer.parseInt(temp[2]);
            examInfos[jsNo] = new ExamInfo(zkzNo, jsNo, ksNo);
        }
        int m = Integer.parseInt(br.readLine());
        String[] jsNos = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            examInfos[Integer.parseInt(jsNos[i])].print();
        }
    }
}
