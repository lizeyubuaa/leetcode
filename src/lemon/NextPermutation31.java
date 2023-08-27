package lemon;

public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while (i >= 0 && nums[j] <= nums[i]) {
            i--;
            j--;
        }

        if (i >= 0) {
            while (nums[i] >= nums[k]) {
                k--;
            }
            nums = swap(nums, i, k);
        }
        i = j;
        j = nums.length - 1;
        while (i < j) {
            nums = swap(nums, i, j);
            i++;
            j--;
        }
    }

    public int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return nums;
    }
}
