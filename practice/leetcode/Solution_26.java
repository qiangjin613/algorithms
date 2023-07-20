package leetcode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 */
public class Solution_26 {

    /**
     * 双指针
     * <ul>
     * <li> 快指针：扫描数组，查找非重复的元素
     * <li> 慢指针：慢指针的下一个位置可覆盖的位置
     * </ul>
     */
    public int removeDuplicates(int[] nums) {
        int slow, fast;
        for (slow = 0, fast = slow + 1; fast < nums.length;) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                nums[++slow] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_26().removeDuplicates(new int[]{1, 1, 2}));
    }
}
