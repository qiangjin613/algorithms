package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/jewels-and-stones/">771. 宝石与石头</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_771 {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelSet.add(jewels.charAt(i));
        }
        int answer = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewelSet.contains(stones.charAt(i))) {
                answer ++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_771().numJewelsInStones("aA", "aAAbbbb"));
    }
}
