package Chapter6;

import java.util.*;

public class Combination77 {
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> path = new ArrayDeque<Integer>();
        backTrack(n, k, path);
        return result;
    }

    public void backTrack(int n, int k, Deque<Integer> path) {
        if (k == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }
        int curr_last = path.peekLast() == null ? 0 : path.peekLast();
        System.out.println(curr_last);
        for (int i = 1; i <= n; i++) {
            if (i > curr_last) {
                path.addLast(i);
                backTrack(n, k, path);
                path.removeLast();
            }
        }
    }
}
