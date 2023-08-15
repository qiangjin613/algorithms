package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/minimum-window-substring/">76. 最小覆盖子串</a>
 */
public class Solution_76 {

    /**
     * 双指针 - 滑动窗口
     */
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;
        Map<Character, Integer> windowMap = new HashMap<>(), needMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 窗口内有效的数据
        int valid = 0;
        while (right < s.length()) {
            // 更新窗口内数据
            char added = s.charAt(right);
            if (needMap.containsKey(added)) {
                windowMap.put(added, windowMap.getOrDefault(added, 0) + 1);
                if (windowMap.get(added).equals(needMap.get(added))) {
                    valid ++;
                }
            }

            // 扩大窗口
            right ++;

            // 当查找到字串时进行更新
            while (valid == needMap.keySet().size()) {
                // 当查找到的字串比上一个小时更新字串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char removed = s.charAt(left);
                left ++;
                if (needMap.containsKey(removed)) {
                    if (windowMap.get(removed).equals(needMap.get(removed))) {
                        valid --;
                    }
                    windowMap.put(removed, windowMap.get(removed) - 1);
                }
            }
        }
        return len != Integer.MAX_VALUE ? s.substring(start, start + len) : "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution_76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
