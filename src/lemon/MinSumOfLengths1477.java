package lemon;

public class MinSumOfLengths1477 {
    // 滑动窗口+动规
    public int minSumOfLengths(int[] arr, int target) {
        int length = arr.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int minLen = arr.length + 1;

        int[] dp = new int[length + 1];
        dp[0] = arr.length + 1;

        for (r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                minLen = Math.min(minLen, dp[l] + r - l + 1);
                dp[r + 1] = Math.min(dp[r], r - l + 1);
            } else dp[r + 1] = dp[r];
        }

        return minLen == arr.length + 1 ? -1 : minLen;

    }
}
