package leetcode;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/">746. 使用最小花费爬楼梯</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_746 {

    public int minCostClimbingStairs(int[] cost) {
        // dp[i] 表示达到下标 i 的最小花费
        int[] dp = new int[cost.length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            // 到达第 i 层的花费只与 i - 1 和 i - 2 有关
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_746().minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(new Solution_746().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
