package Chapter2;

public class NonDecreasing665 {
    public boolean checkPossibility(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                if (flag == 0){
                    flag = 1;
                    if(i == 0 || nums[i + 1] >= nums[i - 1]) nums[i] = nums[i + 1];
                    else nums[i + 1] = nums[i];
                }
                else return false;
            }
        }
        return true;
    }
}
