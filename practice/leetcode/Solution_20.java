package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/description/">20. 有效的括号</a>
 */
public class Solution_20 {

    /**
     * 解法一（经典）：使用 Stack 进行判断
     */
    public boolean isValid(String s) {
        if (s.length() <= 1 || s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (getRight(s.charAt(i)) != 0) {
                stack.addFirst(s.charAt(i));
            } else {
                Character character = stack.pollFirst();
                if (character == null || getRight(character) != s.charAt(i)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public char getRight(char left) {
        switch (left) {
            case '(': return ')';
            case '[': return ']';
            case '{': return '}';
            default: return 0;
        }
    }

    /**
     * 解法二：使用双指针处理
     */


    public static void main(String[] args) {
        System.out.println(new Solution_20().isValid("("));
    }
}
