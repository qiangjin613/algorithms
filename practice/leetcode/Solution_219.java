package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/">219. 存在重复元素 II</a>
 */
public class Solution_219 {

    /**
     * 哈希表
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hashTable = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            Integer index = hashTable.get(nums[i]);
            if (index != null && Math.abs(index - i) <= k) {
                return true;
            } else {
                hashTable.put(nums[i], i);
            }
        }
        return false;
    }

    /**
     * 滑动窗口
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> window = new HashSet<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (window.contains(nums[i])) {
                return true;
            } else {
                window.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_219().containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
        System.out.println(new Solution_219().containsNearbyDuplicate2(new int[] {1, 0, 1, 1}, 1));
    }
}
