package leetcode;

/**
 * <a href="https://leetcode.cn/problems/longest-uncommon-subsequence-ii/">522. 最长特殊序列 II</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_522 {

    public int findLUSlength(String[] strs) {
        int maxLen = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                // 判断 strs[i] 是否为 strs[j] 的子序列
                if (subSeq(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                maxLen = Math.max(maxLen, strs[i].length());
            }
        }
        return maxLen;
    }

    /**
     * Note: 如果两个字符串相等，也是子序列
     */
    private boolean subSeq(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            // 所有字符匹配完毕
            if (s.charAt(i) == c && ++i == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_522().subSeq("abac","abac"));
        System.out.println(new Solution_522().findLUSlength(new String[] {"abac","abac","aa","aaa"}));
        System.out.println(new Solution_522().findLUSlength(new String[] {"abac","abac","abc","ac"}));
        System.out.println(new Solution_522().findLUSlength(new String[] {"aaa","aaa","aaa"}));
        System.out.println(new Solution_522().findLUSlength(new String[] {"aba","cdc","eae"}));
        System.out.println(new Solution_522().findLUSlength(new String[] {"abaa","aaa","aaa"}));
        System.out.println(new Solution_522().findLUSlength(new String[] {"aba","aa","aaa"}));
    }
}
