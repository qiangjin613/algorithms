package leetcode;

/**
 * <a href = "https://leetcode.cn/problems/reverse-words-in-a-string-iii/">557. 反转字符串中的单词 III</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_557 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (j < chars.length) {
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
            i = ++j;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int a, int b) {
        while (a < b) {
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution_557().reverseWords("Let's take LeetCode contest"));
    }
}
