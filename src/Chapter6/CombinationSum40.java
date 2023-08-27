package Chapter6;

import java.util.*;

public class CombinationSum40 {
    private final Deque<Integer> current = new ArrayDeque<>();
    private final List<List<Integer>> result = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return new ArrayList<>();
        visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTrace(candidates, target, 0, 0);
        return result;
    }

    private void backTrace(int[] candidates, int target, int index, int sum) {

        for (int i = index; i < candidates.length; i++) {
            if (visited[i] || (i > 0 && candidates[i - 1] == candidates[i] && !visited[i - 1])) continue;
            else if (sum + candidates[i] == target) {
                current.addLast(candidates[i]);
                result.add(new ArrayList<>(current));
                current.removeLast();
            }
            else if (sum + candidates[i] > target) {
                return;
            }
            else {
                current.addLast(candidates[i]);
                visited[i] = true;
                backTrace(candidates, target, i + 1, sum + candidates[i]);
                current.removeLast();
                visited[i] = false;
            }
        }
    }
}