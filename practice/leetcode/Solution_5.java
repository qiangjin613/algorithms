package leetcode;

/**
 * <a href = "https://leetcode.cn/problems/longest-palindromic-substring/description/">5. 最长回文子串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_5 {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindrome(String str, int left, int right) {
        // 防止索引越界
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--; right++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return str.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_5().longestPalindrome("babad"));
    }
}
