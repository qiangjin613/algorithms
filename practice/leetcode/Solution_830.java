package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/positions-of-large-groups">830. 较大分组的位置</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_830 {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            char charI = s.charAt(i);
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == charI) {
                j++;
            }
            if (j - i >= 3) {
                ans.add(new ArrayList<>(Arrays.asList(i, j - 1)));
            }
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_830().largeGroupPositions("abbxxxxzyy"));
    }
}
