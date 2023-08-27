package Chapter7;

import java.util.Arrays;
import java.util.Collections;

public class IntegerBreak343 {
    public int integerBreak(int n) {
        // 注意数字和索引的对应关系 数字1对应着索引1
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Collections.max(Arrays.asList(dp[i], j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}