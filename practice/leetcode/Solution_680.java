package leetcode;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome-ii/description/">680. 验证回文串 II</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_680 {

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                // 删掉一个后，判断是否为回文串
                return validPalindrome(chars, l + 1, r) || validPalindrome(chars, l, r - 1);
            }
        }
        return true;
    }

    private boolean validPalindrome(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_680().validPalindrome("aba"));
        System.out.println(new Solution_680().validPalindrome("abca"));
    }
}
