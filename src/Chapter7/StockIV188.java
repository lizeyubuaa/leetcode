package Chapter7;

import java.util.Arrays;

public class StockIV188 {
    // k次交易
    public int maxProfit(int k, int[] prices) {
        // 没发生交易
        if (k == 0) return 0;
        // 相当于无限次交易
        else if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) profit += prices[i + 1] - prices[i];
            }
            return profit;
        }

        // 第i次买入时的最大收益
        int[] buy = new int[k + 1];
        // 第i次卖出时的最大收益
        int[] sell = new int[k + 1];
        // 初始化
        // 因为要与自己比较，要注意
        // buy的利润可能为负，sell的利润不可能为负
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);

        // 每天都要更新
        for (int price : prices) {
            for (int j = 0; j < k; j++) {
                // 多次更新要和自己比较
                buy[j + 1] = Math.max(buy[j + 1], sell[j] - price);
                sell[j + 1] = Math.max(sell[j + 1], buy[j + 1] + price);
            }
        }
        return sell[k];
    }
}
