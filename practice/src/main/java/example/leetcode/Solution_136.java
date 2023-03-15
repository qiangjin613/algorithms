package example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/single-number/">136. 只出现一次的数字</a>
 */
public class Solution_136 {

    /**
     * 暴力循环 + 剪枝
     */
    public int singleNumber(int[] nums) {
        boolean flag;
        Set<Integer> cache = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            flag = false;
            if (cache.contains(nums[i])) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    flag = true;
                    cache.add(nums[i]);
                    break;
                }
            }
            if (!flag) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 哈希
     */
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>(nums.length);
        // 数据入表
        for (int j : nums) {
            Integer num = hashTable.get(j);
            if (num == null) {
                hashTable.put(j, 1);
            } else {
                hashTable.put(j, 2);
            }
        }
        // 查表
        for (Integer num : hashTable.keySet()) {
            if (hashTable.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 数学：利用<b>亦或运算</b>的自反性，如 a ^ b ^ a = b。
     * <p>
     * NOTE：也可以用来求取集合中为单的数。如 [1, 1, 1, 1, 2] -> 2。
     */
    public int singleNumber3(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_136().singleNumber(new int[]{2}));
        System.out.println(new Solution_136().singleNumber2(new int[]{2}));
        System.out.println(new Solution_136().singleNumber3(new int[]{2}));
    }
}
