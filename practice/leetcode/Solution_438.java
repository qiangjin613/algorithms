package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/find-all-anagrams-in-a-string/">438. 找到字符串中所有字母异位词</a>
 */
public class Solution_438 {

    /**
     * 双指针 - 滑动窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0;

        // 准备 s 数据
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char temp = p.charAt(i);
            need.put(temp, need.getOrDefault(temp, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int check = 0;
        List<Integer> result = new LinkedList<>();
        while (right < s.length()) {
            // 更新窗口数据
            char addData = s.charAt(right);
            if (need.containsKey(addData)) {
                window.put(addData, window.getOrDefault(addData, 0) + 1);
                if (window.get(addData).equals(need.get(addData))) {
                    check ++;
                }
            }
            // 扩大窗口
            right ++;

            // 检测数据
            if (right - left == p.length()) {
                char removed = s.charAt(left);
                if (check == need.keySet().size()) {
                    result.add(left);
                }
                if (window.containsKey(removed)) {
                    if (window.get(removed).equals(need.get(removed))) {
                        check --;
                    }
                    window.put(removed, window.getOrDefault(removed, 0) - 1);
                }
                left ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_438().findAnagrams("cbaebabacd", "abc"));
    }
}
