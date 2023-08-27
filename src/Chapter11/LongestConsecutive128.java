package Chapter11;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        long res = 1L;
        Set<Long> cache = new HashSet<>();
        for (long num : nums) {
            cache.add(num);
        }
        while (!cache.isEmpty()) {
            Long curr = cache.iterator().next();
            cache.remove(curr);
            long next = curr + 1;
            long prev = curr - 1;
            while (cache.contains(next)) {
                cache.remove(next);
                next += 1;
            }
            while (cache.contains(prev)) {
                cache.remove(prev);
                prev -= 1;
            }
            res = Math.max(res, next - prev - 1);
            // 剪枝
            if (res >= nums.length) break;
        }
        return (int) res;
    }
}