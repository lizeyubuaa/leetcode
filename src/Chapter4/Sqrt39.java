package Chapter4;

public class Sqrt39 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1;
        int r = x;
        int mid = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((long) mid * mid == x) return mid;
            else if ((long) mid * mid < x) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }
}