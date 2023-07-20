package leetcode;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/">303. 区域和检索 - 数组不可变</a>
 */
public class Solution_303 {

    /**
     * 遍历
     */
    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

    /**
     * 前缀和，arr[i] = arr[i] + arr[i - 1] (i > 0)
     * <p>
     * NOTE：对计算结果进行缓存，从而减少循环遍历
     */
    class NumArray2 {
        int[] nums;

        public NumArray2(int[] nums) {
            this.nums = nums;
            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return left == 0 ? nums[right] : nums[right] - nums[left - 1];
        }
    }

    public static void main(String[] args) {
        NumArray2 obj = new Solution_303().new NumArray2(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
    }
}
