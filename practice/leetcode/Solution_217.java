package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate/">217. 存在重复元素</a>
 */
public class Solution_217 {

    /**
     * 哈希表
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>(16);
        for (int num : nums) {
            Integer count = hashTable.get(num);
            if (count != null) {
                return true;
            } else {
                hashTable.put(num, 1);
            }
        }
        return false;
    }

    /**
     * 排序
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_217().containsDuplicate(new int[] {1,2,3,0}));
    }
}
