package leetcode;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/description/">392. 判断子序列</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_392 {

    /**
     * 方法一：双指针
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i ++;
            }
            j ++;
        }
        return i == s.length();
    }

    /**
     * todo 方法二：动态规划
     * <p>
     * 是对方法一的优化，从方法一注意到，有大量的时间用于在 t 中找到下一个匹配字符，
     * 可以预处理出对于 t 的每一个位置，从该位置开始往后每一个字符第一次出现的位置。
     * <a href="https://leetcode.cn/problems/is-subsequence/solutions/346539/pan-duan-zi-xu-lie-by-leetcode-solution/">题解：方法二：动态规划</a>
     */
    public boolean isSubsequence2(String s, String t) {
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_392().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution_392().isSubsequence("axc", "ahbgdc"));
    }
}
