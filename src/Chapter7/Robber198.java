package Chapter7;

public class Robber198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int pre1 = Math.max(nums[0], nums[1]);
        int pre2 = nums[0];
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            res = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}