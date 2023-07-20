package leetcode;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">121. 买卖股票的最佳时机</a>
 */
public class Solution_121 {

    /**
     * 暴力解法
     * <ul>
     * <li>时间复杂度：O(n^2)
     * <li>空间复杂度：O(1)
     * </ul>
     */
    public int maxProfit(int[] prices) {
        int maxProfit, tempProfit;
        maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                tempProfit = prices[j] - prices[i];
                if (tempProfit > maxProfit) {
                    maxProfit = tempProfit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 动态规划
     * <ul>
     * <li>时间复杂度：O(n)
     * <li>空间复杂度：O(1)
     * </ul>
     */
    public int maxProfit2(int[] prices) {
        int maxProfit, minProfit;
        maxProfit = 0;
        minProfit = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minProfit) {
                minProfit = prices[i];
            } else if (prices[i] - minProfit > maxProfit) {
                maxProfit = prices[i] - minProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution_121().maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
