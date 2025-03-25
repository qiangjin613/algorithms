package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/buddy-strings">859. 亲密字符串</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_859 {

    /**
     * ‘笨模拟’，可以通过 字符串是否相等，来分为两个逻辑处理，代码复杂度会更低。
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        Set<Character> used = new HashSet<>();
        boolean sample = false;
        int[] swapIndex = new int[2];
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (len < 2) {
                    swapIndex[len] = i;
                }
                len ++;
            } else if (!used.add(s.charAt(i))){
                sample = true;
            }
        }
        if (len > 2) {
            return false;
        }
        if (len == 2 && s.charAt(swapIndex[0]) == goal.charAt(swapIndex[1]) && s.charAt(swapIndex[1]) == goal.charAt(swapIndex[0])) {
            return true;
        }
        return len == 0 && sample;
    }

    /**
     * 切换一个字符顺序相等的奥义，同时满足：
     *  1. 字符长度相同；
     *  2. s 与 goal 每个字符的数量相同
     *  3. （s 与 goal 字符位置不同为 2） or （s 与 goal 相同，但 goal 中存在相同的字符）
     */
    public boolean buddyStrings2(String s, String goal) {
        int sLen = s.length(), gLen = goal.length();
        if (sLen != gLen) {
            return false;
        }
        int[] sCnt = new int[26], gCnt = new int[26];
        int difIndex = 0;
        // 统计单词出现的个数、不同的位置
        for (int i = 0; i < s.length(); i++) {
            int indexS = s.charAt(i) - 'a', indexG = goal.charAt(i) - 'a';
            sCnt[indexS] ++;
            gCnt[indexG] ++;
            if (indexS != indexG) {
                difIndex ++;
            }
        }
        boolean sameWord = false;
        for (int i = 0; i < 26; i++) {
            // 能交换相等的前提是：字符的数量必须相等
            if (sCnt[i] != gCnt[i]) {
                return false;
            }
            if (sCnt[i] >= 2) {
                sameWord = true;
            }
        }
        return difIndex == 2 || (difIndex == 0 && sameWord);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_859().buddyStrings("ab", "ba"));
        System.out.println(new Solution_859().buddyStrings("ab", "ab"));
        System.out.println(new Solution_859().buddyStrings2("aa", "aa"));
        System.out.println(new Solution_859().buddyStrings("abcd", "badc"));
    }
}
