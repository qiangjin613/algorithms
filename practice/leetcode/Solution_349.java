package leetcode;

import java.util.*;

/**
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_349 {

    /**
     * 遍历 + 标记
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> nums1Used = new HashMap<>(16);
        for (int num : nums1) {
            nums1Used.put(num, Boolean.TRUE);
        }
        Set<Integer> intersection = new HashSet<>(16);
        for (int num : nums2) {
            if (nums1Used.containsKey(num)) {
                intersection.add(num);
            }
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for (Integer num : intersection) {
            result[i++] = num;
        }
        return result;
    }

    /**
     * 排序 + 双指针
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int intersectionLength = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                if (intersectionLength == 0 || intersection[intersectionLength - 1] != nums1[i]) {
                    intersection[intersectionLength++] = nums1[i];
                }
                i++;
                j++;
            }
        }

        return Arrays.copyOfRange(intersection, 0, intersectionLength);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_349().intersection2(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
