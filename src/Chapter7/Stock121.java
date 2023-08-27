package Chapter7;

public class Stock121 {
    // 一次交易
    public int maxProfit(int[] prices) {
        int l_price = prices[0];
        int profit = 0;
        for (int price : prices) {
            l_price = Math.min(l_price, price);
            profit = Math.max(profit, price - l_price);
        }
        return profit;
    }
}
