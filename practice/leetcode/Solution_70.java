package leetcode;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/">70. 爬楼梯</a>
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
     * 也可以把 [备忘录] 传进去进行处理
     */
    public int climbStairs_2(int n) {
        int[] memo = new int[50];
        return dp(memo, n);
    }

    private int dp(int[] memo, int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_70().climbStairs(2));
    }
}
