package Chapter4;

public class TwoArray4 {
    // key： 假设我们要找第 k 小数，我们可以每次循环排除掉 k/2 个数。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int left = (length1 + length2 + 1) / 2;
        int right = (length1 + length2 + 2) / 2;
        return (double) (findKthMin(nums1, 0, length1 - 1, nums2, 0, length2 - 1, left) + findKthMin(nums1, 0, length1 - 1, nums2, 0, length2 - 1, right)) / 2;
    }

    public int findKthMin(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        // 调换位置
        if (length1 > length2) return findKthMin(nums2, start2, end2, nums1, start1, end1, k);
        // 递归结束条件：数组1为空；k = 1
        if (length1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        // 正常递归，考虑取length和k / 2的最小避免数组越界
        int left1 = start1 + Math.min(length1, k / 2) - 1;
        int left2 = start2 + Math.min(length2, k / 2) - 1;
        if (nums1[left1] > nums2[left2])
            return findKthMin(nums1, start1, end1, nums2, left2 + 1, end2, k - (left2 - start2 + 1));
        else return findKthMin(nums1, left1 + 1, end1, nums2, start2, end2, k - (left1 - start1 + 1));
    }
}
