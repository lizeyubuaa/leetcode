package Chapter7;

import java.util.Arrays;

public class RobberⅡ213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) {
            return nums[0];
        }
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 分成了两种情况，转化为了简单问题
        return Math.max(rob_range(Arrays.copyOfRange(nums, 1, nums.length)), rob_range(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private int rob_range(int[] nums) {
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}