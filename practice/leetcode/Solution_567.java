package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/permutation-in-string/">567. 字符串的排列</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_567 {

    /**
     * 双指针 - 滑动窗口
     */
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int windowLen = s1.length();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        while (right < s2.length()) {
            char added = s2.charAt(right);
            if (need.containsKey(added)) {
                window.put(added, window.getOrDefault(added, 0) + 1);
                if (window.get(added).equals(need.get(added))) {
                    valid ++;
                }
            }
            // 增加窗口
            right ++;

            // 如果窗口长度 == s1 字符串长度进行判断是否满足包含要求
            if (right - left == windowLen) {
                if (valid == need.size()) {
                    return true;
                }
                // 移除窗口内的有效数据
                char removed = s2.charAt(left);
                if (window.containsKey(removed)) {
                    if (window.get(removed).equals(need.get(removed))) {
                        valid --;
                    }
                    window.put(removed, window.get(removed) - 1);
                }
                // 缩短窗口
                left ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_567().checkInclusion("ab", "eidboaoo"));
    }
}
