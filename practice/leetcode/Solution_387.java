package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/first-unique-character-in-a-string/">387. 字符串中的第一个唯一字符</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_387 {

    public int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        // 打表
        int[] flag = new int[26];
        for (char c : str) {
            flag[c - 'a'] ++;
        }

        // 查找
        for (int i = 0; i < s.length(); i++) {
            if (flag[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_387().firstUniqChar("leetcode"));
        System.out.println(new Solution_387().firstUniqChar("loveleetcode"));
        System.out.println(new Solution_387().firstUniqChar("aabb"));
    }
}
