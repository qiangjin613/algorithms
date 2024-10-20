package leetcode;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.cn/problems/array-partition/">561. 数组拆分</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_561().arrayPairSum(new int[] {1,4,3,2}));
        System.out.println(new Solution_561().arrayPairSum(new int[] {6,2,6,5,1,2}));
    }
}


/*
1, 2, 3, 4
x     x

1, 2, 2, 5, 6, 6
X     X     X
 */