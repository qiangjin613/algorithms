package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/relative-ranks/">506. 相对名次</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_506 {

    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>(score.length);
        for (int i = 0; i < score.length; i++) {
            map.put(i, score[i]);
        }
        // 升序排序
        Arrays.sort(score);

        Map<Integer, String> map1 = new HashMap<>(score.length);
        String[] awards = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = score.length - 1; i >= 0 ; i--) {
            if (i >= score.length - 3) {
                map1.put(score[i], awards[score.length - i - 1]);
            } else {
                map1.put(score[i], score.length - i + "");
            }
        }

        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            res[i] = map1.get(map.get(i));
        }

        return res;
    }

    /**
     * 使用数组代替 map
     * <p>
     * <a href="https://leetcode.cn/problems/relative-ranks/solutions/1131693/xiang-dui-ming-ci-by-leetcode-solution-5sua/">力扣官方题解</a>
     */
    public String[] findRelativeRanks2(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        // 以整个 arr[i] 为单位进行排序
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_506().findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(new Solution_506().findRelativeRanks(new int[]{10,3,8,9,4})));
    }
}
