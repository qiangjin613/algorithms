package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/assign-cookies/">455. 分发饼干</a>
 */
public class Solution_455 {

    /**
     * 排序 + 双指针
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_455().findContentChildren(new int[] {1,2,2}, new int[] {1,2,3}));
    }
}
