package leetcode;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/">242. 有效的字母异位词</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 可进空间上的优化：使用 c - 'a' 将序列平移到 0~26 的区间内
        int[] flag = new int[256];
        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i)] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            // 不存在该元素
            if (flag[temp] == 0) {
                return false;
            }
            // 该元素资源减少
            flag[temp] --;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_242().isAnagram("abc", "ccb"));
    }
}
