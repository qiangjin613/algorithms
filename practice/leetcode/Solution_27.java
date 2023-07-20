package leetcode;

/**
 * <a href="https://leetcode.cn/problems/remove-element/">27. 移除元素</a>
 */
public class Solution_27 {

    public int removeElement(int[] nums, int val) {
        int arrayLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[arrayLength++] = nums[i];
            }
        }
        return arrayLength;
    }
}
