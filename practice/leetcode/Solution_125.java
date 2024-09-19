package leetcode;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/description/">125. 验证回文串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_125 {

    public boolean isPalindrome(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
            if (!isCode(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isCode(s.charAt(j))) {
                j--;
                continue;
            }
            if (!isEqual(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isCode(char c) {
        return ('a' <= c && 'z' >= c) || ('A' <= c && 'Z' >= c) || ('0' <= c && '9' >= c);
    }

    private boolean isEqual(char a, char b) {
        if ('A' <= a && 'Z' >= a) {
            a += 32;
        }
        if ('A' <= b && 'Z' >= b) {
            b += 32;
        }
        return a == b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
