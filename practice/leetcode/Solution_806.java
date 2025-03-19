package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/number-of-lines-to-write-string">806. 写字符串需要的行数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_806 {

    public int[] numberOfLines(int[] widths, String s) {
        int curRowNum = 0;
        int[] ans = new int[] {1, 0};
        for (char c : s.toCharArray()) {
            curRowNum += widths[c - 'a'];
            if (curRowNum > 100) {
                ans[0] ++;
                curRowNum = widths[c - 'a'];
            }
            ans[1] = curRowNum;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_806().numberOfLines(new int[]{
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                "abcdefghijklmnopqrstuvwxyz")));
    }
}
