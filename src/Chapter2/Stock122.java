package Chapter2;

public class Stock122 {
    // 无限次交易
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) profit += (prices[i + 1] - prices[i]);
        }
        return profit;
    }
}
