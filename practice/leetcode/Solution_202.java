package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/happy-number/">202. 快乐数</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_202 {

    public boolean isHappy(int n) {
        Set<Integer> calculated = new HashSet<>(16);
        while (n != 1) {
            if (!calculated.add(n)) {
                return false;
            }

            int curSum = 0, temp;
            while (n != 0) {
                temp = n % 10;
                n /= 10;
                curSum += temp * temp;
            }

            n = curSum;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_202().isHappy(Integer.MAX_VALUE));
    }
}
