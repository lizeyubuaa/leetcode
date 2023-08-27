package Chapter11;


import java.util.*;

public class FindDisappear448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] state = new boolean[n];
        for (int num : nums) {
            state[num - 1] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < state.length; i++) {
            if (!state[i]) res.add(i + 1);
        }
        return res;
    }
}
