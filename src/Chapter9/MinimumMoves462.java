package Chapter9;

import java.util.Arrays;

// 差的平方和 Σ(x-t)^2 最小时，t 为平均值；差的绝对值之和 Σ|x-t| 最小时，t 为中位数。
public class MinimumMoves462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ret = 0, x = nums[n / 2];
        for (int num : nums) {
            ret += Math.abs(num - x);
        }
        return ret;
    }
}
