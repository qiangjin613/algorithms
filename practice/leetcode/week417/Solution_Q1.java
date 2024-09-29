package leetcode.week417;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-417/problems/find-the-k-th-character-in-string-game-i/description/">Q1. 找出第 K 个字符 I</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_Q1 {

    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            int curLen = sb.length();
            for (int i = 0; i < curLen; i++) {
                char c = (char) (((sb.charAt(i) - 'a' + 1) % 26) + 'a');
                sb.append(c);
            }
        }
        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_Q1().kthCharacter(500));
    }
}
