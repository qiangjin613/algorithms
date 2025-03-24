package leetcode;

/**
 * <a href="https://leetcode.cn/problems/backspace-string-compare">844. 比较含退格的字符串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_844 {

    /**
     * 快慢指针
     */
    public boolean backspaceCompare(String s, String t) {
        int sLen = s.length() - 1, tLen = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (sLen >= 0 || tLen >= 0) {
            while (sLen >= 0) {
                if (s.charAt(sLen) == '#') {
                    skipS ++;
                    sLen --;
                } else if (skipS > 0) {
                    skipS --;
                    sLen --;
                } else {
                    break;
                }
            }
            while (tLen >= 0) {
                if (t.charAt(tLen) == '#') {
                    skipT ++;
                    tLen --;
                } else if (skipT > 0) {
                    skipT --;
                    tLen --;
                } else {
                    break;
                }
            }
            if (sLen >= 0 && tLen >= 0) {
                if (s.charAt(sLen) != t.charAt(tLen)) {
                    return false;
                }
            } else {
                if (sLen >= 0 || tLen >= 0) {
                    return false;
                }
            }

            sLen --;
            tLen --;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_844().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new Solution_844().backspaceCompare("ab##", "c#d#"));
    }
}
