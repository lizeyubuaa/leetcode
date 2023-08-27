package Chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StockWithFee714 {
    // 一定是k次交易（最大次数交易）的利润最大值
    public int maxProfit(int[] prices, int fee) {
        int k = prices.length / 2;
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        // 初始化
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);

        // 状态转移方程
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i - 1]);
                sell[j] = Math.max(sell[j], buy[j] - fee + prices[i - 1]);
            }
        }
        return Arrays.stream(sell).max().getAsInt();
    }

    // 类似冷却机制的状态机
    public int maxProfit2(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];

        // 初始化
        buy[0] = -prices[0];
        s1[0] = -prices[0];
        sell[0] = 0;
        s2[0] = 0;

        // 状态转移方程
        for (int i = 1; i < prices.length; i++) {
            // 注意price的索引
            // 注意交易费与初始化项目的对应
            buy[i] = Math.max(s2[i - 1], sell[i - 1]) - prices[i];
            sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i] - fee;
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);
            s2[i] = Math.max(sell[i - 1], s2[i - 1]);
        }
        return Math.max(sell[prices.length - 1], s2[prices.length - 1]);
    }

    // 简化状态机
    public int maxProfit3(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        // 初始化
        buy[0] = -prices[0];
        sell[0] = 0;

        // 状态转移方程
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }
}