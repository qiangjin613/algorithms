package leetcode;

/**
 * <a href="https://leetcode.cn/problems/student-attendance-record-i/">551. 学生出勤记录 I</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_551 {

    public boolean checkRecord(String s) {
        int aCnt = 0;
        int latCnt = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'A':
                    aCnt++;
                    latCnt = 0;
                    break;
                case 'L':
                    latCnt++;
                    break;
                default:
                    latCnt = 0;
            }
            if (aCnt >= 2 || latCnt >= 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_551().checkRecord("PPALLP"));
        System.out.println(new Solution_551().checkRecord("PPALLL"));
        System.out.println(new Solution_551().checkRecord("AA"));
    }
}
