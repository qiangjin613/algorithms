package leetcode;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">14. 最长公共前缀</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_14 {

    /**
     * 解法一：两两比较
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int flag = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            flag = Math.min(flag, strs[i].length());
            for (int strIndex = 0; strIndex < strs[i].length() && strIndex < flag; strIndex++) {
                if (strs[i].charAt(strIndex) != strs[0].charAt(strIndex)) {
                    flag = strIndex;
                    break;
                }
            }
        }

        return strs[0].substring(0, flag);
    }

    /**
     * 解法二：假设结果，再判断是否满足
     */
    public String longestCommonPrefix_2(String[] strs) {
        if (strs.length == 1 || strs[0].length() == 0) {
            return strs[0];
        }

        int preIndex = 0;
        while (samePrefix(strs, preIndex)) {
            preIndex ++;
        }

        return strs[0].substring(0, preIndex);
    }

    private boolean samePrefix(String[] strs, int index) {
        if (index >= strs[0].length()) {
            return false;
        }
        char baseChar = strs[0].charAt(index);
        for (int i = 1; i < strs.length; i++) {
            if (index > strs[i].length() -1 || baseChar != strs[i].charAt(index)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_14().longestCommonPrefix_2(new String[]{"flower","flower","flower","flower"}));
    }
}
