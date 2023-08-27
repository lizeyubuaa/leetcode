package Chapter2;

public class Array665 {
    public boolean checkPossibility(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                if (index == 0) index = i + 1;
                else return false;
            }
        }
        return index <= 1 || index == nums.length - 1 || nums[index + 1] - nums[index - 1] >= 0 || nums[index] - nums[index - 2] >= 0;
    }
}