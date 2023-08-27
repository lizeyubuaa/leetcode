package Chapter11;

public class FindDuplicate287 {
    public int findDuplicate(int[] nums) {
        // 建图：i -> nums[i]，target存在多个入边，即存在环路
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
