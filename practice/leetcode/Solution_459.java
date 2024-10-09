package leetcode;

/**
 * <a href="https://leetcode.cn/problems/repeated-substring-pattern/">459. 重复的子字符串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_459 {

    /**
     * 方法一：枚举
     */
    public boolean repeatedSubstringPattern(String s) {
        // 设定步长
        for (int step = 1; step <= s.length() / 2; step++) {
            if (s.length() % step != 0) {
                continue;
            }
            // 贪心枚举
            boolean match = true;
            for (int i = 0; i < s.length() / 2 && match; i++) {
                char c = s.charAt(i);
                for (int j = i + step; j < s.length(); j += step) {
                    if (c != s.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法一的优化
     */
    public boolean repeatedSubstringPattern2(String s) {
        int len = s.length();
        // i 即表示索引，也代表步长
        for (int i = 1; i <= len / 2; i++) {
            if (len % i != 0) {
                continue;
            }
            boolean match = true;
            for (int j = i; j < len; j ++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    /**
     * TODO <a href="https://leetcode.cn/problems/repeated-substring-pattern/solutions/386481/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/">方法三：KMP 字符串匹配</a>
     */
    public boolean repeatedSubstringPattern3(String s) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_459().repeatedSubstringPattern2("aabaaba"));
        System.out.println(new Solution_459().repeatedSubstringPattern2("abab"));
    }
}
