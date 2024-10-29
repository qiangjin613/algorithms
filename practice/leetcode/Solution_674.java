package leetcode;

/**
 * <a href="https://leetcode.cn/problems/longest-continuous-increasing-subsequence/">674. 最长连续递增序列</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_674 {

    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        for (int i = 0, j = 1; i < nums.length; i = j, j++) {
            while (j < nums.length && nums[j - 1] < nums[j])  {
                j++;
            }
            if (ans < j - i) {
                ans = j - i;
            }
        }
        return ans;
    }

    /**
     * 对上述代码进行优化，降低阅读复杂度
     */
    public int findLengthOfLCIS2(int[] nums) {
        int ans = 1;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                start = i;
            }
            if (ans < i - start + 1) {
                ans = i - start + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_674().findLengthOfLCIS(new int[] {1,3,5,4,7}));
    }
}
