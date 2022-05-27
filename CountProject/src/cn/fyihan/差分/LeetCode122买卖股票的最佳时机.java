package cn.fyihan.差分;

public class LeetCode122买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[100001];

        int sumMax = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                sumMax += prices[i] - prices[i-1];
            }
        }
        return sumMax;
    }
}

