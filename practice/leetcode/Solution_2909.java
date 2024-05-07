package leetcode;

/**
 * <a href="https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-ii/">2909. 元素和最小的山形三元组 II</a>
 */
public class Solution_2909 {

    public int minimumSum(int[] nums) {
        // 后缀最小值
        int[] suf = new int[nums.length];
        suf[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suf[i] = Math.min(nums[i], suf[i + 1]);
        }

        // 前缀最小值、 更新答案
        int minSum = Integer.MAX_VALUE;
        int pre = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (pre < nums[i] && nums[i] > suf[i + 1]) {
                minSum = Math.min(minSum, pre + nums[i] + suf[i + 1]);
            }
            pre = Math.min(pre, nums[i]);
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_2909().minimumSum(new int[]{8,6,1,5,3}));
    }
}
