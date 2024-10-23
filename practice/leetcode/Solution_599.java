package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-index-sum-of-two-lists/">599. 两个列表的最小索引总和</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int minIndexSum = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();

        Map<String, Integer> map1 = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (!map1.containsKey(list2[i])) {
                continue;
            }
            int curIndexSum = map1.get(list2[i]) + i;
            if (curIndexSum < minIndexSum) {
                minIndexSum = curIndexSum;
                ans.clear();
                ans.add(list2[i]);
            } else if (curIndexSum == minIndexSum) {
                ans.add(list2[i]);
            }
        }

        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_599().findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));

        System.out.println(Arrays.toString(new Solution_599().findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"})));
    }
}
