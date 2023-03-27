package example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/">350. 两个数组的交集 II</a>
 */
public class Solution_350 {

    /**
     * 排序 + 双指针
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int iLength = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                intersection[iLength++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOfRange(intersection, 0, iLength);
    }

    /**
     * 哈希表
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num1Counts = new HashMap<>(16);
        for (int num : nums1) {
            Integer numKey = num1Counts.get(num);
            if (numKey == null) {
                num1Counts.put(num, 1);
            } else {
                num1Counts.put(num, ++numKey);
            }
        }

        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int iLength = 0;
        for (int num : nums2) {
            Integer num2Key = num1Counts.get(num);
            if (num2Key != null && num2Key > 0) {
                intersection[iLength++] = num;
                num1Counts.put(num, --num2Key);
            }
        }

        return Arrays.copyOfRange(intersection, 0, iLength);
    }

    /**
     * 打表
     */
    public int[] intersect3(int[] nums1, int[] nums2) {
        int[] signArr = new int[1001];
        for (int num : nums1) {
            signArr[num]++;
        }

        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int iLength = 0;
        for (int num : nums2) {
            if (signArr[num] > 0) {
                intersection[iLength++] = num;
                signArr[num]--;
            }
        }

        return Arrays.copyOfRange(intersection, 0, iLength);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_350().intersect2(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
