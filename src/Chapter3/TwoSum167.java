package Chapter3;

public class TwoSum167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int temp;
        while ((temp = numbers[l] + numbers[r]) != target) {
            if (temp < target) l += 1;
            else r -= 1;
        }
        return new int[]{l + 1, r + 1};
    }
}
