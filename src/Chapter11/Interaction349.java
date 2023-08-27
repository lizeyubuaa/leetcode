package Chapter11;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Interaction349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toCollection(HashSet::new));
        HashSet<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(HashSet::new));
        set2.retainAll(set1);
        return set2.stream().mapToInt(Integer::intValue).toArray();
    }
}
