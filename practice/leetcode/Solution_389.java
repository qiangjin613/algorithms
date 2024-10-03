package leetcode;

/**
 * <a href="https://leetcode.cn/problems/first-unique-character-in-a-string/">387. 字符串中的第一个唯一字符</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_389 {

    public char findTheDifference(String s, String t) {
        int[] flagS = new int[26];
        for (char c : s.toCharArray()) {
            flagS[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            flagS[c - 'a'] --;
            if (flagS[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Solution_389().findTheDifference("abcd", "abcde"));
    }
}
