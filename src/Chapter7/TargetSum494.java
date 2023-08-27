package Chapter7;

import java.util.Arrays;

public class TargetSum494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int neg_sum;

        // 数学推导
        // 注意negsum<0的情况
        if ((sum - target) % 2 == 0 && sum >= target) neg_sum = (sum - target) / 2;
        else return 0;

        // dp[i][j] 表示在数组nums的前i个数中选取元素，使得这些元素之和等于j的方案数
        int[][] dp = new int[nums.length + 1][neg_sum + 1];
        // 初始化
        // 已经默认初始化为0
        dp[0][0] = 1;

        // 状态转移
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= neg_sum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[nums.length][neg_sum];
    }
}