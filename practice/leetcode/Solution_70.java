package leetcode;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/">70. 爬楼梯</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_70 {

    int[] mark = new int[50];

    /**
     * dp：状态转移方程：f(x) = f(x - 1) + f(x - 2)
     * 使用备忘录进行优化
     */
    public int climbStairs(int n) {
        // base case
        if (n == 1 || n == 0) {
            return 1;
        }
        // 备忘录优化
        if (mark[n] != 0) {
            return mark[n];
        }
        // 状态转移方程
        mark[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return mark[n];
    }

    /**
     * DP 备忘录
     */
    public int climbStairs_2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_70().climbStairs(2));
    }
}
