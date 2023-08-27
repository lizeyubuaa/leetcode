package Chapter11;

public class RangeSum303 {
    private int[] partial_sum;

    public RangeSum303(int[] nums) {
        partial_sum = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            partial_sum[i] = partial_sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return partial_sum[right + 1] - partial_sum[left];
    }
}
