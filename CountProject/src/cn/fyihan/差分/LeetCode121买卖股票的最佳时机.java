package cn.fyihan.差分;

/**
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */
public class LeetCode121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[100001];

        int maxPrice = Integer.MIN_VALUE;
        for (int i=1; i<prices.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + prices[i] - prices[i-1];
            } else {
                dp[i] = prices[i] - prices[i-1];
            }
            maxPrice = Math.max(maxPrice, dp[i]);
        }
        if (maxPrice < 0) {
            maxPrice = 0;
        }
        return maxPrice;
    }
}
