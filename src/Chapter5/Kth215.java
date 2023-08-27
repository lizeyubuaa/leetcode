package Chapter5;

public class Kth215 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int target_index = nums.length - k;
        int current_index;
        // 查找 + 排序
        while (l <= r) {
            current_index = quickSort(nums, l, r);

            if (current_index == target_index) return nums[current_index];
            else if (current_index > target_index) r = current_index - 1;
            else l = current_index + 1;
        }
        // 题目假定解一定存在，一定不会在这个return
        return -1;
    }

    public static int quickSort(int[] nums, int l, int r) {
        int left = l;
        int temp;
        while (l < r) {
            while (l < r && nums[r] >= nums[left]) r--;
            while (l < r && nums[l] <= nums[left]) l++;
            if (l < r) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                // 注意没有l++和r--
            }
        }
        temp = nums[r];
        nums[r] = nums[left];
        nums[left] = temp;
        return r;
    }
}