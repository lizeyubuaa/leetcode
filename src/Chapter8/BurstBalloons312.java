package Chapter8;

import java.util.Arrays;


public class BurstBalloons312 {
    public int[][] rec;
    public int[] val;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 创建一个首尾各多一个元素的数组
        val = new int[n + 2];
        System.arraycopy(nums, 0, val, 1, n);
        val[0] = 1;
        val[n + 1] = 1;

        // 记忆中间结果
        rec = new int[n + 2][n + 2];
        // 初始化
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        // 含有首尾
        return solve(0, n + 1);
    }

    public int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        // 直接返回
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        // 0 - n
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }

    public int maxCoins2(int[] nums) {
        int maxCoin = 0;
        int currentCoin;
        int n = nums.length;
        if (n == 1) return nums[0];

        for (int i = 0; i < n; i++) {
            if (i == 0) currentCoin = nums[0] * nums[1] + maxCoins(Arrays.copyOfRange(nums, 1, n));
            else if (i == n - 1) currentCoin = nums[n - 1] * nums[n - 2] + maxCoins(Arrays.copyOfRange(nums, 0, n - 1));
            else
                currentCoin = nums[i] * nums[i - 1] * nums[i + 1] + maxCoins(Arrays.copyOfRange(nums, 0, i)) + maxCoins(Arrays.copyOfRange(nums, i + 1, n));

            maxCoin = Math.max(maxCoin, currentCoin);
        }
        return maxCoin;
    }
}
