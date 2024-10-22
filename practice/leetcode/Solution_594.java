package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-harmonious-subsequence/">594. 最长和谐子序列</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_594 {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> sortedMap = new HashMap<>();
        List<Integer> dummyNums = new ArrayList<>();
        for (int num : nums) {
            Integer cnt = sortedMap.get(num);
            if (cnt == null) {
                sortedMap.put(num, 1);
                dummyNums.add(num);
            } else {
                sortedMap.put(num, cnt + 1);
            }
        }
        Collections.sort(dummyNums);
        int ans = 0;
        for (int i = 1; i < dummyNums.size(); i++) {
            if (Math.abs(dummyNums.get(i) - dummyNums.get(i - 1)) == 1) {
                ans = Math.max(ans, sortedMap.get(dummyNums.get(i)) + sortedMap.get(dummyNums.get(i - 1)));
            }
        }
        return ans;
    }

    /**
     * 优化
     */
    public int findLHS2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> dummyNums = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Integer key : map.keySet()) {
            Integer cnt = map.get(key + 1);
            if (cnt != null) {
                ans = Math.max(ans, cnt + map.get(key));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution_594().findLHS(new int[] {1,3,2,2,5,2,3,7}));
        System.out.println(new Solution_594().findLHS(new int[] {1,2,3,4}));
        System.out.println(new Solution_594().findLHS(new int[] {1,1,1,1}));
    }
}
