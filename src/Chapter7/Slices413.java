package Chapter7;

import java.util.ArrayList;
import java.util.Arrays;

public class Slices413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int[] states = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                states[i] = states[i - 1] + 1;
            }
        }
        return Arrays.stream(states).sum();
    }
}
