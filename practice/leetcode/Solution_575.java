package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href = "https://leetcode.cn/problems/distribute-candies/">575. 分糖果</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_575 {

    public int distributeCandies(int[] candyType) {
        Set<Integer> type = new HashSet<>();
        for (int i : candyType) {
            type.add(i);
        }
        return Math.min(candyType.length / 2, type.size());
    }

    public static void main(String[] args) {
        System.out.println(new Solution_575().distributeCandies(new int[] {1,1,2,2,3,3}));
    }
}
