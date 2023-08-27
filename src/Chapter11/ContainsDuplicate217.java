package Chapter11;

import java.util.HashSet;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> state = new HashSet<>();
        for (int num : nums) {
            if(state.contains(num)) return true;
            state.add(num);
        }
        return false;
    }
}
