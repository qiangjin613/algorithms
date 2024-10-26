package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/set-mismatch/">645. 错误的集合</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_645 {

    public int[] findErrorNums(int[] nums) {
        int[] flag = new int[nums.length + 1];
        int[] ans = new int[2];
        for (int num : nums) {
            if (flag[num] == 1) {
                ans[0] = num;
            }
            flag[num] = 1;
        }
        for (int i = 1; i < flag.length; i++) {
            if(flag[i] == 0) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_645().findErrorNums(new int[]{3,3,1})));
        System.out.println(Arrays.toString(new Solution_645().findErrorNums(new int[]{3,2,3,4,6,5})));
        System.out.println(Arrays.toString(new Solution_645().findErrorNums(new int[]{3,2,2})));
        System.out.println(Arrays.toString(new Solution_645().findErrorNums(new int[]{1,2,2,4})));
        System.out.println(Arrays.toString(new Solution_645().findErrorNums(new int[]{1,1})));
        System.out.println(Arrays.toString(new Solution_645().findErrorNums(new int[]{1,2,3,5})));
    }
}
