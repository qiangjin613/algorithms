package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-of-three-numbers/">628. 三个数的最大乘积</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }

    /**
     * 方法2：使用线性扫描也可以完成，并且时间复杂度更低
     * <p>
     * <a href="https://leetcode.cn/problems/maximum-product-of-three-numbers/solutions/567309/san-ge-shu-de-zui-da-cheng-ji-by-leetcod-t9sb/">方法二：线性扫描</a>
     */
    public int maximumProduct2(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_628().maximumProduct(new int[] {1,2,3,4}));
        System.out.println(new Solution_628().maximumProduct(new int[] {-1111, -232, -21, 1,2,3,4}));
    }
}
