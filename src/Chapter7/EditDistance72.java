package Chapter7;

import java.util.Arrays;
import java.util.Collections;

public class EditDistance72 {
    public int minDistance(String word1, String word2) {
        // word1的前i个序列与word2的前j个序列需要多少次编辑距离
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                // 初始化
                if (i == 0 || j == 0) dp[i][j] = Math.max(i, j);
                // 特殊情况
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    // 三种本质
                else
                    // 递推公式
                    dp[i][j] = Collections.min(Arrays.asList(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
