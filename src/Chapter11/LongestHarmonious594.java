package Chapter11;

import java.util.HashMap;

public class LongestHarmonious594 {
    public int findLHS(int[] nums) {
        // 记录元素出现的次数
        HashMap<Integer, Integer> state = new HashMap<>();
        for (int num : nums) {
            state.put(num, state.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Integer integer : state.keySet()) {
            if(state.containsKey(integer + 1)) res = Math.max(res, state.get(integer) + state.get(integer + 1));
        }
        return res;
    }
}
