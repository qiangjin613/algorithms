package leetcode;

/**
 * <a href="https://leetcode.cn/problems/maximum-average-subarray-i/">643. 子数组最大平均数 I</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_643 {

    /**
     * 值得关注的是 maxSum 的处理
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_643().findMaxAverage(new int[] {-1}, 4));
        System.out.println(new Solution_643().findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
    }
}
