package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/corporate-flight-bookings/">1109. 航班预订统计</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_1137 {

    public int tribonacci(int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // 状态转移方程
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }


    public Map<Integer, Integer> results = new HashMap<>(16);
    /**
     * 对 {@link #tribonacci(int)} 使用 [备忘录] 优化
     */
    public int tribonacci2(int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        if (results.containsKey(n)) {
            return results.get(n);
        }

        // 状态转移方程
        int curRes = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        results.put(n, curRes);
        return curRes;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_1137().tribonacci(4));
        System.out.println(new Solution_1137().tribonacci(25));
    }
}
