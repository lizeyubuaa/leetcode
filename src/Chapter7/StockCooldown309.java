package Chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StockCooldown309 {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];

        // 初始化，没有自己与自己的比较
        buy[0] = -prices[0];
        s1[0] = -prices[0];
        sell[0] = 0;
        s2[0] = 0;

        // 状态转移
        for (int i = 1; i < prices.length; i++) {
            buy[i] = s2[i - 1] - prices[i];
            sell[i] = Math.max(buy[i - 1] + prices[i], s1[i - 1] + prices[i]);
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);
            s2[i] = Math.max(sell[i - 1], s2[i - 1]);
        }
        return Math.max(sell[prices.length - 1], s2[prices.length - 1]);
    }
}
