package leetcode;

/**
 * <a href="https://leetcode.cn/problems/reverse-string-ii/">541. 反转字符串 II</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+= 2 * k) {
            // 反转字符串 (i, i + k)
            int p = i;
            int j = Math.min(p + k - 1, chars.length - 1);
            for (; j > p && j < chars.length ; j--, p++) {
                char temp = chars[p];
                chars[p] = chars[j];
                chars[j] = temp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_541().reverseStr("abcdefg", 8));
        System.out.println(new Solution_541().reverseStr("abcdefg", 2));
        System.out.println(new Solution_541().reverseStr("abcdefg", 8));
    }
}
