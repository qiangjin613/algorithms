package leetcode;

/**
 * <a href="https://leetcode.cn/problems/excel-sheet-column-number/">171. Excel 表列序号</a>
 *
 * @see Solution_168 进制转换（number -> str）（无 0 版）
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_171 {

    /**
     * 进制转换（无 0 版）
     */
    public int titleToNumber(String columnTitle) {
        int num = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int curIndex = columnTitle.charAt(i) - 'A' + 1;
            num += curIndex * multiple;
            multiple *= 26;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_171().titleToNumber("A"));
        System.out.println(new Solution_171().titleToNumber("AB"));
        System.out.println(new Solution_171().titleToNumber("ZY"));
    }
}
