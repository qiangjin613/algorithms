package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/shortest-distance-to-a-character">821. 字符的最短距离</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_821 {

    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        int idx = -len;
        // 先从左往右扫一遍
        // 使用 idx = 字符串长度的负值，这样在左边不存在 c 的时候，其相距的距离比整个字符串的长度还要大
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }
        // 再从右往左扫一遍
        idx = -len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], Math.abs(i - idx));
        }
        return ans;
    }

    /**
     * 扫一遍解决
     */
    public int[] shortestToChar2(String s, char c) {
        int len = s.length(), preIdx = -len, nextIdx = s.indexOf(c);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == nextIdx) {
                preIdx = nextIdx;
                nextIdx = s.indexOf(c, i + 1);
                if (nextIdx == -1) {
                    nextIdx = Integer.MAX_VALUE;
                }
            }
            ans[i] = Math.min(i - preIdx, nextIdx - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_821().shortestToChar2("loveleetcodeaa", 'e')));
    }
}
