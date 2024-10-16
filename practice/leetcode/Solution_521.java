package leetcode;

/**
 * <a href="https://leetcode.cn/problems/longest-uncommon-subsequence-i/">521. 最长特殊序列 Ⅰ</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_521 {

    /**
     * 脑筋急转弯
     * <p>
     * <a href="https://leetcode.cn/problems/longest-uncommon-subsequence-i/solutions/1306210/zui-chang-te-shu-xu-lie-i-by-leetcode-so-v9sr/">力扣官方题解</a>
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        System.out.println(new Solution_521().findLUSlength("aba", "cbc"));
        System.out.println(new Solution_521().findLUSlength("aaa", "bbb"));
        System.out.println(new Solution_521().findLUSlength("aaa", "aaa"));
    }
}
