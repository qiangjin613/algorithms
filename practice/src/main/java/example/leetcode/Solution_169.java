package example.leetcode;

import com.sun.jnlp.JNLPRandomAccessFileNSBImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/majority-element/">169. 多数元素</a>
 */
public class Solution_169 {

    /**
     * 哈希表
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>(16);
        // 存表
        for (int num : nums) {
            Integer numCount = hashTable.get(num);
            if (numCount == null) {
                hashTable.put(num, 1);
            } else {
                hashTable.put(num, ++numCount);
            }
        }
        for (Integer num : hashTable.keySet()) {
            if (hashTable.get(num) >= (nums.length + 1) / 2) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 哈希表 + “打擂台”
     * <p>
     * NOTE：在遍历数组 nums 时候使用打擂台的方法，维护最大的值，省区了最后遍历哈希表的循环。
     * 但归根结底，时间复杂度与 majorityElement 相同，又因在 Java 中存在过多自动拆装箱，性能反倒比上述差些。
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>(16);
        int maxCount = 0;
        int maxValue = -1;
        // 存表
        for (int num : nums) {
            Integer numCount = hashTable.get(num);
            if (numCount == null) {
                numCount = 1;
            }
            hashTable.put(num, ++numCount);
            if (numCount > maxCount) {
                maxCount = numCount;
                maxValue = num;
            }
        }
        return maxValue;
    }

    /**
     * 排序
     * <p>
     * 根据题意，“多数元素”占集合的一大半，即集合中的众数，所以在排序后，其 n/2 的位置就是集合中占比最多的元素。
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 概率（随机化）
     * <p>
     * 随机找一个数，来验证是否为众数。
     */
    public int majorityElement4(int[] nums) {
        Random random = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int curNum = nums[random.nextInt(nums.length)];
            int curNumCount = 0;
            for (int num : nums) {
                if (num == curNum) {
                    curNumCount++;
                }
            }
            if (curNumCount > majorityCount) {
                return curNum;
            }
        }
    }




    public static void main(String[] args) {
        System.out.println(new Solution_169().majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(new Solution_169().majorityElement3(new int[]{2,2,1,1,1,2,2}));
        System.out.println(new Solution_169().majorityElement4(new int[]{2,2,1,1,1,2,2}));
    }
}
