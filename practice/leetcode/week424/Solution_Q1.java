package leetcode.week424;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-424/problems/make-array-elements-equal-to-zero/">Q1. 使数组元素等于零</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_Q1 {

    public int countValidSelections(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            if (deal(Arrays.copyOf(nums, nums.length), i, 1)) {
                ans ++;
            }
            if (deal(Arrays.copyOf(nums, nums.length), i, -1)) {
                ans ++;
            }
        }

        return ans;
    }

    private boolean deal(int[] data, int idx, int aaa) {
        while (idx >= 0 && idx < data.length) {
            if (data[idx] != 0) {
                data[idx] --;
                aaa *= -1;
            }
            idx += aaa;
        }
        return judge(data);
    }

    private boolean judge(int[] data) {
        for (int datum : data) {
            if (datum != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_Q1().countValidSelections(new int[] {2,3,4,0,4,1,0}));
    }
}
