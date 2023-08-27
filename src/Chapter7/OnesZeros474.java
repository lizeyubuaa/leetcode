package Chapter7;

public class OnesZeros474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m + 1][n + 1][strs.length + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 1; k <= strs.length; k++) {
                    int[] counts = count(strs[k - 1]);
                    int count_0 = counts[0];
                    int count_1 = counts[1];
                    if (count_0 > i || count_1 > j) dp[i][j][k] = dp[i][j][k - 1];
                    else {
                        dp[i][j][k] = Math.max(dp[i][j][k - 1], dp[i- count_0][j - count_1][k - 1] + 1);
                    }
                }
            }
        }
        return dp[m][n][strs.length];
    }

    private int[] count(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') res[0] += 1;
            else if (str.charAt(i) == '1') res[1] += 1;
        }
        return res;
    }
}
