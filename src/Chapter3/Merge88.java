package Chapter3;

public class Merge88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1;
        int r = n - 1;
        int pos = m + n - 1;
        while (pos >= 0 && l >= 0 && r >= 0) {
            if (nums1[l] >= nums2[r]) {
                nums1[pos] = nums1[l];
                l -= 1;
            }
            else {
                nums1[pos] = nums2[r];
                r -= 1;
            }
            pos -= 1;
        }
        if (l == -1) {
            System.arraycopy(nums2, 0, nums1, 0, pos + 1);
        }
    }
}