package example.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/third-maximum-number/">414. 第三大的数</a>
 */
public class Solution_414 {

    /**
     * 排序
     */
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = nums.length - 2, sequence = 1; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                sequence++;
            }
            if (sequence == 3) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 模拟有序集合
     * <p>
     * NOTE：因为 -2^31 <= nums[i] <= 2^31 - 1，所以在比较时使用 long 类型的最小值作为无穷小（也可以使用包装类 Integer 为 null 来判断）
     */
    public int thirdMax2(int[] nums) {
        // sortedArr[0] 最大，sortedArr[1] 次之，sortedArr[2] 最小
        long[] sortedArr = new long[3];
        sortedArr[0] = sortedArr[1] = sortedArr[2] = Long.MIN_VALUE;
        for (long num : nums) {
            if (sortedArr[0] < num) {
                sortedArr[2] = sortedArr[1];
                sortedArr[1] = sortedArr[0];
                sortedArr[0] = num;
            } else if (sortedArr[0] > num && sortedArr[1] < num) {
                sortedArr[2] = sortedArr[1];
                sortedArr[1] = num;
            } else if (sortedArr[1] > num && sortedArr[2] < num) {
                sortedArr[2] = num;
            }
        }
        return (int) (sortedArr[2] == Long.MIN_VALUE ?  sortedArr[0] : sortedArr[2]);
    }

    /**
     * 使用 TreeSet
     */
    public int thirdMax3(int[] nums) {
        TreeSet<Integer> sortedNums = new TreeSet<>();
        for (int num : nums) {
            sortedNums.add(num);
            if (sortedNums.size() > 3) {
                sortedNums.remove(sortedNums.first());
            }
        }
        return sortedNums.size() >= 3 ? sortedNums.first() : sortedNums.last();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_414().thirdMax3(new int[] {1,2,-2147483648, 3, 2}));
    }
}
