package leetcode;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">34. 在排序数组中查找元素的第一个和最后一个位置</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_34 {

    /**
     * 该逻辑还可以优化，应为已经知道左边界的索引，所以可以从左边界开始二分查找
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        // 元素的第一个位置
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left >= nums.length) {
            result[0] = -1;
        } else {
            if (target == nums[left]) {
                result[0] = left;
            } else {
                result[0] = -1;
            }
        }

        // 元素的最后一个位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left --;
        if (left >= nums.length || left < 0) {
            result[1] = -1;
        } else {
            if (target == nums[left]) {
                result[1] = left;
            } else {
                result[1] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_34().searchRange(new int[]{}, 6)));
    }
}
