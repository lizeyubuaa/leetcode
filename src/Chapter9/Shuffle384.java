package Chapter9;

import java.util.Arrays;
import java.util.Random;

public class Shuffle384 {
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */

    private final int[] origin;
    private final int[] number;

    public Shuffle384(int[] nums) {
        origin = Arrays.copyOf(nums, nums.length);
        number = Arrays.copyOf(nums, nums.length);
    }


    public int[] reset() {
        return origin;
    }

    // fisher洗牌法
    public int[] shuffle() {
        for (int i = 0; i < number.length; i++) {
            Random random = new Random();
            // 生成[i , number.length - 1]的随机数
            // 可以自己与自己交换
            int target = random.nextInt(number.length - i) + i;
            int temp = number[target];
            number[target] = number[i];
            number[i] = temp;
        }
        return number;
    }
}

