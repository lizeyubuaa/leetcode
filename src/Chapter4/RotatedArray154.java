package Chapter4;

public class RotatedArray154 {
    // 在最小值右侧的元素，它们的值一定都小于等于 x；而在最小值左侧的元素，它们的值一定都大于等于 x
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int pivot = l + (r - l) / 2;
            if (nums[pivot] < nums[r]) {
                r = pivot;
            } else if (nums[pivot] > nums[r]) {
                l = pivot + 1;
            } else {
                r -= 1;
            }
        }
        return nums[r];
    }
}
