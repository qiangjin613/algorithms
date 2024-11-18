package leetcode;

/**
 * <a href="https://leetcode.cn/problems/largest-number-at-least-twice-of-others/">747. 至少是其他数字两倍的最大数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_747 {

    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[maxIndex] * 1.0 / nums[i] < 2) {
                return -1;
            }
        }
        return maxIndex;
    }

    /**
     * 针对上述方法的优化：这里其实是只要最大值大于次大值的两倍，剩下的数据自然也就大于两倍了，没必要计算全部的数据
     */
    public int dominantIndex2(int[] nums) {
        // 最大值、次大值
        int max1 = -1, max2 = -1;
        // 最大值的索引下标
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                index = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max1 >= 2 * max2 ? index : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_747().dominantIndex2(new int[]{3,6,1,0}));
        System.out.println(new Solution_747().dominantIndex2(new int[]{1,2,3,4}));
    }
}
