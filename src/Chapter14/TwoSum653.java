package Chapter14;

import java.util.*;

public class TwoSum653 {
    ArrayList<Integer> data = new ArrayList<>();

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            data.add(root.val);
            dfs(root.right);
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int[] data = this.data.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(data));
        int n = data.length;

        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (data[l] + data[r] > k) r--;
            else if (data[l] + data[r] < k) l++;
            else return true;
        }
        return false;
    }

    Set<Integer> cache = new HashSet<>();

    public boolean findTarget_dfs(TreeNode root, int k) {
        if (root != null) {
            if (cache.contains(k - root.val)) return true;
            cache.add(root.val);
            return findTarget_dfs(root.right, k) || findTarget_dfs(root.left, k);
        }
        return false;
    }
}
