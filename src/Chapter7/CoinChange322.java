package Chapter7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;

        int[][] dp = new int[coins.length + 1][amount + 1];

        // 初始化
        for (int[] ints : dp) {
            Arrays.fill(ints, 1 + amount);
        }
        // 初始化 第一列
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    int count = 1;
                    while (count * coins[i - 1] <= j) {
                        // 放硬币或者不放硬币
                        // dp[i][j] = Collections.min(List.of(dp[i - 1][j], dp[i - 1][j - count * coins[i - 1]] + count, dp[i][j]));

                        // 放硬币
                        if (dp[i - 1][j - count * coins[i - 1]] != amount + 1) {
                            dp[i][j] = Math.min(dp[i - 1][j - count * coins[i - 1]] + count, dp[i][j]);
                        }
                        // 不放硬币
                        if (dp[i - 1][j] != amount + 1) {
                            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j]);
                        }
                        count++;
                    }
                }
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
    }

    // 降为一维数组
// 硬币无限多，代表可以重复用，但要用面额最大的，一次只加一枚硬币
    public int coinChange_dim1(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                else break;
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}