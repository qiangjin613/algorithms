package leetcode;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/">35. 搜索插入位置</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_35 {

    public int searchInsert(int[] nums, int target) {
        int middle, left, right;
        for (left = 0, right = nums.length - 1; left <= right;) {
            middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] >= target) {
                right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_35().searchInsert(new int[]{1, 3, 5}, 3));
    }
}
