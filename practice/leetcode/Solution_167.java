package leetcode;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">167. 两数之和 II - 输入有序数组</a>
 */
public class Solution_167 {

    /**
     * 遍历
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {++i, ++j};
                }
            }
        }
        return null;
    }

    /**
     * 双指针 - 左右指针
     */
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {++ left, ++ right};
            } else if (sum < target) {
                left ++;
            } else {
                right --;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_167().twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }
}
