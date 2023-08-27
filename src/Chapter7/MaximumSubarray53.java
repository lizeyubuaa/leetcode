package Chapter7;

import java.util.Arrays;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i-1], nums[i-1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

