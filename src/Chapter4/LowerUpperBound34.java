package Chapter4;

import java.util.Arrays;

public class LowerUpperBound34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 11;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    // 问题转化为求第一个等于target的index和第一个大于target的index - 1
    // lower为false表示求后者，否则为前者
    public static int[] searchRange(int[] nums, int target) {
        // 空数组
        int[] notFound = new int[]{-1, -1};
        if (nums.length == 0) return notFound;
        int l = binarySearch(nums, target, true);
        int r = binarySearch(nums, target, false) - 1;
        // 返回前还要做条件的校验
        if (l <= r && r < nums.length && nums[l] == target && nums[r] == target) return new int[]{l, r};
        else return notFound;
    }

    // 二分搜索的架子不变
    public static int binarySearch(int[] nums, int target, boolean lower) {
        int l = 0;
        int r = nums.length - 1;
        int ans = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                r = mid - 1;
                ans = mid;
            }
            else l = mid + 1;
        }
        return ans;
    }
}
