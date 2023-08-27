package Chapter5;

public class Colors75 {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int temp;
        for (int i = 0; i <= r; i++) {
            while (i <= r && nums[i] == 2) {
                temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
                r--;
            }
            while (i >= l &&nums[i] == 0) {
                temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
            }
        }
    }
}
