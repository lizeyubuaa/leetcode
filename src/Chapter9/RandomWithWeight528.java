package Chapter9;

import java.util.Arrays;
import java.util.Random;

public class RandomWithWeight528 {
    // 原数组
    private final int[] origin;
    // 前缀和
    private final int[] partial_sum;

    public RandomWithWeight528(int[] w) {
        origin = w;
        partial_sum = Arrays.copyOf(w, w.length);
        for (int i = 1; i < partial_sum.length; i++) {
            partial_sum[i] += partial_sum[i - 1];
        }
    }

    public int pickIndex() {
        // 先生成[0, n)上的整数
        Random random = new Random();
        // 先定区间长度，再定偏移量
        int rand = random.nextInt(partial_sum[partial_sum.length - 1]);

        return binarySearch(rand);
    }

    // 寻找第一个比rand大的index，upperbound
    private int binarySearch(int rand) {
        int l = 0;
        int r = partial_sum.length - 1;
        int mid;
        // 初始化
        int ans = partial_sum.length;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (partial_sum[mid] > rand) {
                r = mid - 1;
                // 固定写法
                ans = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return ans - 1;
    }
}