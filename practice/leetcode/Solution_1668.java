package leetcode;

/**
 * <a href="https://leetcode.cn/problems/maximum-repeating-substring/">1668. 最大重复子字符串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_1668 {

    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        String temp = word;
        while (sequence.contains(temp)) {
            ans ++;
            temp += word;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_1668().maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}
