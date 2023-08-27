package Chapter11;

import java.util.HashMap;

public class Subarray560 {
    public int subarraySum(int[] nums, int k) {
        int partial_sum = 0;
        int counts = 0;
        // {前缀和, 前缀和出现的次数}
        HashMap<Integer, Integer> hash = new HashMap<>();
        // 体现了前缀和数组的个数是nums数组个数 + 1
        hash.put(0, 1);
        for (int num : nums) {
            partial_sum += num;
            if(hash.containsKey(partial_sum - k)) counts += hash.get(partial_sum - k);
            hash.put(partial_sum, hash.getOrDefault(partial_sum, 0) + 1);
        }
        return counts;
    }
}
