package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href = "https://leetcode.cn/problems/reverse-words-in-a-string/">151. 反转字符串中的单词</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_151 {

    public String reverseWords(String s) {
        String[] strArray = s.split(" ");
        LinkedList<String> words = new LinkedList<>();
        for (int i = 0; i < strArray.length; i++) {
            if ("".equals(strArray[i])) {
                continue;
            }
            words.addFirst(strArray[i]);
        }
        return String.join(" ", words);
    }

    public String reverseWords_2(String s) {
        // 特殊情况转为统一处理，如果没有这个处理，可以使用 “Hello   World  ” 作为测试用例试试看会发生什么
        s = ' ' + s;
        StringBuilder res = new StringBuilder();
        for (int right = s.length(), left = right - 1; left >= 0; left--) {
            // 遇到空格，说明获得一个完整单词
            if (s.charAt(left) == ' ') {
                // 防止连续空格的情况
                if (left + 1 < right) {
                    res.append(s, left + 1, right).append(' ');
                }
                // 让right紧跟left，避免连续多个空格被甩开，导致添加单词时候里面有多余空格
                right = left;
            }
        }
        //结尾处理一下多余空格
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_151().reverseWords("  hello    world  "));
        System.out.println(new Solution_151().reverseWords_2("  hello    world  "));
    }
}
