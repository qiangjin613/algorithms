package leetcode.week417;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-417/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/">Q2. 元音辅音字符串计数 I</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_Q2 {

    public int countOfSubstrings(String word, int k) {
        if (word.length() < 5) {
            return 0;
        }
        int res = 0;
        String flagStr = "aeiou";
        Set<Character> used = new HashSet<>(5);
        for (int i = 0; i <= word.length() - 5; i++) {
            // 统计非元音字母数量
            int count = 0;
            for (int j = i; j < word.length(); j++) {
                char cur = word.charAt(j);
                // 元音字母
                if (flagStr.indexOf(cur) >= 0) {
                    used.add(cur);
                } else {
                    count ++;
                }

                if (count > k) {
                    break;
                }
                if (count == k && used.size() == 5) {
                    res ++;
                }
            }
            used.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_Q2().countOfSubstrings("aeiuo", 0));
        System.out.println(new Solution_Q2().countOfSubstrings("aeioqq", 1));
        System.out.println(new Solution_Q2().countOfSubstrings("ieaouqqieaouqq", 1));
    }
}
