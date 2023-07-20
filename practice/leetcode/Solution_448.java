package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/">448. 找到所有数组中消失的数字</a>
 */
public class Solution_448 {

    /**
     * 哈希
     * <ul>
     * <li>时间复杂度：O(n)
     * <li>空间复杂度：O(n)
     * </ul>
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] sign = new boolean[nums.length + 1];
        for (int num : nums) {
            sign[num] = true;
        }
        List<Integer> unSign = new ArrayList<>(16);
        for (int i = 1; i < sign.length; i++) {
            if (!sign[i]) {
                unSign.add(i);
            }
        }
        return unSign;
    }

    /**
     * 原地哈希
     * <p>
     * 因为 nums 中的数字 [1, n]，所以可以用这个范围之外的数字来标记是否出现过的含义。
     * <p>
     * 当 +n 时，nums 数字一定会超过 n，对 nums[i] % n 也可以获得 nums[i] 在 +n 之前的值。
     * <ul>
     * <li>时间复杂度：O(n)
     * <li>空间复杂度：O(1)
     * </ul>
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1) % nums.length;
            nums[index] += nums.length;
        }
        List<Integer> unSign = new ArrayList<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                unSign.add(i + 1);
            }
        }
        return unSign;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_448().findDisappearedNumbers2(new int[]{4,3,2,7,8,2,3,1}));
    }
}
