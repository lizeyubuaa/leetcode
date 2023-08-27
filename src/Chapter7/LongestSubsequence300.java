package Chapter7;

import java.util.Arrays;

public class LongestSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        int[] states = new int[nums.length];
        // 最小长度为1
        Arrays.fill(states, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 递增 不能相等
                if (nums[i] > nums[j]) states[i] = Math.max(states[i], states[j] + 1);
            }
            res = Math.max(res, states[i]);
        }
        return res;
    }
}
