package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href = "https://leetcode.cn/problems/advantage-shuffle/">870. 优势洗牌</a>
 */
public class Solution_870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 优先队列，存储：nums2 的元素值及其对应的索引
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((int[] pair1, int[] pair2) -> pair2[0] - pair1[0]);
        for (int i = 0; i < nums2.length; i++) {
            maxQueue.add(new int[] {nums2[i], i});
        }

        Arrays.sort(nums1);

        int left = 0, right = nums1.length - 1;
        int[] result = new int[nums1.length];
        while (!maxQueue.isEmpty()) {
            int[] pair = maxQueue.poll();
            int maxValue = pair[0], maxValueIndex = pair[1];
            if (nums1[right] > maxValue) {
                result[maxValueIndex] = nums1[right];
                right --;
            } else {
                result[maxValueIndex] = nums1[left];
                left ++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_870().advantageCount(new int[] {12,24,8,32}, new int[] {13,25,32,11})));
    }
}
