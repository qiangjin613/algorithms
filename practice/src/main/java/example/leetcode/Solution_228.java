package example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/summary-ranges/">228. 汇总区间</a>
 */
public class Solution_228 {

    /**
     * 模拟 + 遍历
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>(16);
        if (nums.length == 0) {
            return ranges;
        }

        String range = nums[0] + "";
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                if (range.equals(nums[i] + "")) {
                    ranges.add(range);
                } else {
                    ranges.add(range + "->" + nums[i]);
                }
                range = nums[i + 1] + "";
            }
        }

        if (range.equals(nums[nums.length - 1] + "")) {
            ranges.add(range);
        } else {
            ranges.add(range + "->" + nums[nums.length - 1]);
        }
        return ranges;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_228().summaryRanges(new int[] {0,1,2,4,5,7}));
    }
}
