package leetcode;

import leetcode.structure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/longest-palindrome/description/">409. 最长回文串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_409 {

    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int[] flags = new int[26 * 2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                flags[c - 'a']++;
            } else {
                flags[c - 'A' + 26] ++;
            }
        }
        boolean include = false;
        int length = 0;
        for (int flag : flags) {
            if (flag % 2 != 0) {
                include = true;
                flag --;
            }
            if (flag > 1) {
                length += flag / 2 * 2;
            }

            // 简化 if 逻辑
            /*
                length += flag / 2 * 2;
                // 如果当前字符的数量为奇数，且回文串长度为偶数，就可以再取出一个，作为回文中心。
                if (flag % 2 == 1 && length % 2 == 0) {
                    length ++;
                }
            */
        }
        return include ? length  + 1 : length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_409().longestPalindrome("cccdd"));
        System.out.println(new Solution_409().longestPalindrome("AAAAAA"));
    }
}
