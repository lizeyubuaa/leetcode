package Chapter4;


public class RotatedArray81 {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            // 存在重复值，无法判断区间增序情况
            if (nums[mid] == nums[l]) l++;
            // 存在重复值，无法判断区间增序情况
            else if (nums[mid] == nums[r]) r--;
            // 右区间增序
            else if (nums[mid] < nums[r]) {
                if (target <= nums[r] && target > nums[mid]) l = mid + 1;
                else r = mid - 1;
            }
            // 左区间增序
            else {
                if (target < nums[mid] && target >= nums[l]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return false;
    }
}

