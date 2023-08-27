package Chapter6;

import java.util.*;

public class PermuteUnique47 {
    private final Deque<Integer> current = new ArrayDeque<>();
    private final List<List<Integer>> result = new ArrayList<>();
    private boolean[] visited;


    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        backTrace(nums, 0);
        return result;

    }

    private void backTrace(int[] nums, int length) {
        if (length == nums.length) result.add(new ArrayList<>(current));
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) continue;
            visited[i] = true;
            current.addLast(nums[i]);
            backTrace(nums, length + 1);
            visited[i] = false;
            current.removeLast();
        }
    }
}
