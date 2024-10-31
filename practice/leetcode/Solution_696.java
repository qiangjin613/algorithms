package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/count-binary-substrings/">696. 计数二进制子串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_696 {

    /**
     * 在这个逻辑中，重复出现不同位置的字串也统计其次数
     */
    public int countBinarySubstrings(String s) {
        List<Integer> temps = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == c) {
                j++;
            }
            temps.add(j - i);
            i = j;
        }

        int ans = 0;
        for (int j = 1; j < temps.size(); j++) {
            ans += Math.min(temps.get(j - 1), temps.get(j));
        }

        return ans;
    }

    /**
     * 对上述代码的优化
     */
    public int countBinarySubstrings2(String s) {
        int i = 0, len = s.length();
        int last = 0;
        int ans = 0;
        while (i < len) {
            char temp = s.charAt(i);
            int j = i + 1;
            while (j < len && s.charAt(j) == temp) {
                j++;
            }

            int curVal = j - i;
            if (last != 0) {
                ans += Math.min(last, curVal);
            }
            last = curVal;

            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_696().countBinarySubstrings("00110011"));
    }
}
