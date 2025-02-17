package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        int check = 0, result = 0;
        while (right < s.length()) {
            // 更新窗口数据
            char add = s.charAt(right);
            window.put(add, window.getOrDefault(add, 0) + 1);
            if (window.get(add) == 1) {
                check ++;
            }
            // 扩大窗口
            right ++;

            // 检测数据（check 也代表 [left, right)  无重复字符的最长子串长度
            if (check == right - left) {
                if (result < check) {
                    result = check;
                }
            }
            while (check != right - left) {
                // 缩小窗口
                char remove = s.charAt(left);
                if (window.containsKey(remove)) {
                    if (window.get(remove) == 1) {
                        check --;
                    }
                    window.put(remove, window.get(remove) - 1);
                }
                left ++;
            }
        }
        return result;
    }

    /**
     * 双指针（滑动窗口）
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) {
            return 0;
        }
        // 记录 元素在数据中上一次出现的位置
        HashMap<Character, Integer> window = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            char addData = s.charAt(i);
            // 收缩窗口
            if(window.containsKey(addData)){
                left = Math.max(left, window.get(addData) + 1);
            }
            window.put(addData, i);
            // 更新答案
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_3().lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(new Solution_3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution_3().lengthOfLongestSubstring("asdfghjkl"));
    }
}
