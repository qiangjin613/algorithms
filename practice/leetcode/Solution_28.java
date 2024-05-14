package leetcode;

/**
 * <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/">28. 找出字符串中第一个匹配项的下标</a>
 */
public class Solution_28 {

    /**
     * 使用 Java String SDK
     */
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

    /**
     * 使用 KMP 算法
     */
    public int strStr_2(String haystack, String needle) {

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_28().strStr("sadbutsad", "1sad"));
    }

}
