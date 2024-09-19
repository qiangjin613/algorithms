package leetcode;

/**
 * <a href="https://leetcode.cn/problems/excel-sheet-column-title/description/">168. Excel表列名称</a>
 *
 * @see Solution_171 进制转换（str -> number）（无 0 版）
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_168 {

    /**
     * 进制转换（无 0 版）
     */
    public String convertToTitle(int columnNumber) {
        int len = 26;
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber --;
            res.append((char) (columnNumber % len + 'A'));
            columnNumber /= len;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_168().convertToTitle(1));
        System.out.println(new Solution_168().convertToTitle(28));
        System.out.println(new Solution_168().convertToTitle(701));
        System.out.println(new Solution_168().convertToTitle(2147483647));
    }
}
