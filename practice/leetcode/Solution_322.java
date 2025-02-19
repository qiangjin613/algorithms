package leetcode;

/**
 * <a href = "https://leetcode.cn/problems/coin-change/">322. 零钱兑换</a>
 *
 * @author <a href="mailto:qiangjin613@163.com">qiangjin</a>
 */
public class Solution_322 {

    /**
     * 自上而下 DP
     * 定义：要凑出金额 amount，至少要 dp(coins, amount) 个硬币
     */
    public int coinChange(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子问题
            int subAnswer = coinChange(coins, amount - coin);
            if (subAnswer == -1) {
                continue;
            }
            // 在子问题中选择最优解
            answer = Math.min(answer, subAnswer + 1);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // TODO 优化：使用 [备忘录] 保存已经算过的值
    public int coinChange2(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子问题
            int subAnswer = coinChange(coins, amount - coin);
            if (subAnswer == -1) {
                continue;
            }
            // 在子问题中选择最优解
            answer = Math.min(answer, subAnswer + 1);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_322().coinChange(new int[] {1, 2, 5}, 11));
    }
}
