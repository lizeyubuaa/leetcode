package lemon;

import java.util.Arrays;

public class NextGreaterElement556 {
    public int nextGreaterElement(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        if(nums.length <= 1) return -1;
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
        else return -1;

        i = j;
        j = nums.length - 1;
        while (i < j) {
            nums = swap(nums, i, j);
            i++;
            j--;
        }

        long res =  Long.parseLong(new String(nums));
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }

    public char[] swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return nums;
    }
}
