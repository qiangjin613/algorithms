package leetcode;

/**
 * <a href="https://leetcode.cn/problems/rotate-string/">796. 旋转字符串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_796 {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        s += s;
        return s.contains(goal);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_796().rotateString("", ""));
    }
}
