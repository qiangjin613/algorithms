package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/reverse-vowels-of-a-string/description/">345. 反转字符串中的元音字母</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_345 {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (!set.contains(chars[i]) && i < chars.length - 1) {
                i ++;
            };
            while (!set.contains(chars[j]) && j > 0) {
                j --;
            }
            if (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_345().reverseVowels("IceCreAm"));
        System.out.println(new Solution_345().reverseVowels(".,"));
    }
}
