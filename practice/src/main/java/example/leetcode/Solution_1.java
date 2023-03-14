package example.leetcode;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">1. 两数之和</a>
 */
public class Solution_1 {

    /**
     * 暴力扫描
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i ,j};
                }
            }
        }
        return null;
    }

    /**
     * 使用哈希表进行优化，对数据进行缓存，减少一次循环
     * <p>
     * Note: 可以在一个循环中进行查找和构建哈希表，是应为 c - a = b 等价于 c - b = a。
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashTable = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
           if (hashTable.containsKey(target - nums[i])) {
               return new int[] {i, hashTable.get(target - nums[i])};
           } else {
               hashTable.put(nums[i], i);
           }
        }
        return null;
    }

    public static void main(String[] args) {
        new Solution_1().twoSum2(new int[] {2,7,11,15}, 9);
    }
}
