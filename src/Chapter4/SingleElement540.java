package Chapter4;

public class SingleElement540 {
    public static void main(String[] args) {
        int[] test = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(test));
    }

    // 对于下标 x 左边的下标 y，如果nums[y]=nums[y+1]，则 y 一定是偶数；
    // 对于下标 x 右边的下标 z，如果nums[z]=nums[z+1]，则 z 一定是奇数。
    // 由于下标 x 是相同元素的开始下标的奇偶性的分界，因此可以使用二分查找的方法寻找下标 xxx
    public static int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        // 关键点1
        while (l < r) {
            int mid = (r - l) / 2 + l;
            // 关键点2
            if (nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[r];
    }
}

