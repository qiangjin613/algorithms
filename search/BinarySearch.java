/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 查找左侧边界
     * <p>如：{@code [1, 2, 2, 2, 3]} 寻找 左边第一个 2
     */
    public static int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.leftBound(new int[]{1, 1, 2, 2, 2, 3}, 2));
    }
}
