package Chapter7;

import java.util.Arrays;

public class Partition416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        // dp[i][j] 从nums数组0-i的下标中取一些元素，是否有一种方案使得和恰好为j
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // 初始化：i=0表示不取任何元素
        dp[0][0] = true;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    // 初始化：j=0表示目标为0
                    dp[i][j] = true;
                }
                // 不加入元素i，nums[i - 1]已经比目标j大
                else if (nums[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else {
                    // 加入或者不加入，有一种能行就行
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
