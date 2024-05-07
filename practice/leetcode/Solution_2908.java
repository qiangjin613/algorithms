package leetcode;

/**
 * <a href="https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i/description/">2908. 元素和最小的山形三元组 I</a>
 */
public class Solution_2908 {

    public int minimumSum(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for (int j = 1; j < nums.length - 1; j++) {
            for (int i = 0; i < j; i++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        int tempSum = nums[i] + nums[j] + nums[k];
                        if (tempSum < minSum) {
                            minSum = tempSum;
                        }
                    }
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    /**
     * 优化：剪枝
     */
    public int minimumSum2(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for (int j = 1; j < nums.length - 1; j++) {
            if (nums[j] >= minSum) {
                continue;
            }
            for (int i = 0; i < j; i++) {
                if (nums[i] >= minSum) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] >= minSum) {
                        continue;
                    }
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        int tempSum = nums[i] + nums[j] + nums[k];
                        if (tempSum < minSum) {
                            minSum = tempSum;
                        }
                    }
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_2908().minimumSum(new int[]{50,17,49,12,22,23,23,13,17,3}));
    }
}
