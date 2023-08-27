package Chapter11;

import java.util.Arrays;

public class Chunk769 {
    public int maxChunksToSorted(int[] arr) {
        int max = arr[0];
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res += 1;
            }
        }
        return res;
    }
}
