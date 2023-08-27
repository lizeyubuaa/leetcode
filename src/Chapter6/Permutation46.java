package Chapter6;

import java.util.*;

public class Permutation46 {
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 整个递归过程共享变量
        boolean[] used = new boolean[nums.length];
        // 整个递归过程共享变量
        Deque<Integer> path = new ArrayDeque<Integer>();
        backTrack(nums, path);

        return result;
    }

    private void backTrack(int[] nums, Deque<Integer> path) {
        // 结束条件
        if (path.size() == nums.length) {
            // 传一份拷贝
            result.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (!path.contains(num)) {
                path.addLast(num);
                // 递归
                backTrack(nums, path);
                // 回溯，执行逆操作
                path.removeLast();
            }
        }
    }
}
