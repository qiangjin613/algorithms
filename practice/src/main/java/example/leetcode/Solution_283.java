package example.leetcode;

/**
 *
 */
public class Solution_283 {

    /**
     * 遍历
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 指向一个为 0 的位置
            if (nums[i] != 0) {
                continue;
            }
            boolean flag = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 双指针
     */
    public void moveZeroes2(int[] nums) {
        int n = nums.length, slow = 0, fast = 0;
        while (fast < n) {
            if (nums[fast] != 0) {
                if (fast != slow) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
                slow++;
            }
            fast++;
        }
    }

    /**
     * 双指针
     */
    public void moveZeroes3(int[] nums) {
        int slow = 0;
        // 使用不为 0 的数字向前覆盖
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow++] = nums[i];
            }
        }
        // 将剩下的元素全部置为 0
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }

    public static void main(String[] args) {
        new Solution_283().moveZeroes3(new int[] {1,1,0,3,12});
    }
}
