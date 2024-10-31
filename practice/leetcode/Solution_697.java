package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/degree-of-an-array/">697. 数组的度</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_697 {

    public int findShortestSubArray(int[] nums) {
        // 数组中出现的频率最高的数字及其出现的次数
        int maxCnt = 0;
        int[] cnts = new int[50_000];

        // 标记最后一次出现的位置
        Map<Integer, Integer> flagMap = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!flagMap.containsKey(nums[i])) {
                flagMap.put(nums[i], i);
            }

            // 记录最大数
            cnts[nums[i]]++;
            if (cnts[nums[i]] > maxCnt) {
                maxCnt = cnts[nums[i]];
            }
        }

        int ans = Integer.MAX_VALUE;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!used.add(nums[i]) || cnts[nums[i]] != maxCnt) {
                continue;
            }
            Integer index = flagMap.get(nums[i]);
            ans = Math.min(ans, index - i + 1);
        }

        return ans;
    }

    /**
     * 上述代码的优化：遍历 nums，记录其对应的第一次和最后一次出现的索引位置
     */
    public int findShortestSubArray2(int[] nums) {
        // 标记该元素，出现的次数 和 第一次、最后一次出现的位置
        Map<Integer, int[]> flagMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (flagMap.containsKey(nums[i])) {
                flagMap.get(nums[i])[0]++;
                flagMap.get(nums[i])[2] = i;
            } else {
                flagMap.put(nums[i], new int[] {1, i, i});
            }
        }

        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : flagMap.entrySet()) {
            int[] flags = entry.getValue();
            if (flags[0] > maxNum) {
                maxNum = flags[0];
                minLen = flags[2] - flags[1] + 1;
            } else if (maxNum == flags[0]) {
                minLen = Math.min(minLen, flags[2] - flags[1] + 1);
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_697().findShortestSubArray(new int[] {49999,1,1,1,2,1}));
        System.out.println(new Solution_697().findShortestSubArray2(new int[] {1,2,2,1,2,1,1,1,1,2,2,2}));
    }
}
