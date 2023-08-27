package Chapter11;

import java.util.HashMap;

public class Degree697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> state = new HashMap<>();
        int degree = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int[] value;
            if (state.containsKey(num)) {
                value = state.get(num);
                value[1] = i;
                value[2] += 1;
                degree = Math.max(degree, value[2]);
            }
            else {
                value = new int[]{i, i, 1};
            }
            state.put(num, value);
        }
        int res = nums.length;
        for (int[] value : state.values()) {
            if (value[2] == degree) {
                res = Math.min(res, value[1] - value[0] + 1);
            }
        }
        return res;
    }
}
