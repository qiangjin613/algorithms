package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/word-pattern/description/">290. 单词规律</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_290 {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> c2s = new HashMap<>();
        String[] strArray = s.split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char index = pattern.charAt(i);
            String value = c2s.get(index);
            // 不存在 k -> v 的映射，并且 v 也没有被映射过
            if (value == null && c2s.containsValue(strArray[i])) {
                return false;
            }
            if (value == null) {
                c2s.put(index, strArray[i]);
                continue;
            }
            // 存在 k-> v 的映射，但是映射关系不一致
            if (!value.equals(strArray[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_290().wordPattern("aaa", "cat cat cat cat"));
        System.out.println(new Solution_290().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution_290().wordPattern("abba", "dog dog dog dog"));
    }
}
