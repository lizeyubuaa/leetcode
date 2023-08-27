package Chapter7;

import java.util.Arrays;

public class KeyBoard650 {
    public static void main(String[] args) {
        minSteps(15);
    }
    public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j * j <= i; j++) {
                // 合数
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
