package Chapter14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestorBinaryTree236 {
    // 相当于双向链表，存所有节点的父节点
    Map<Integer, TreeNode> cache = new HashMap<>();
    // 存根节点到p节点path上的节点
    Set<TreeNode> visited = new HashSet<>();

    public void dfs(TreeNode root, TreeNode pre) {
        if (root != null) {
            cache.put(root.val, pre);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, null);
        while (p != null) {
            // 父节点可以是自身，要先加入visited
            visited.add(p);
            p = cache.get(p.val);
        }
        while (q != null) {
            // 父节点可以是自身，要先看q是不是父节点
            if (visited.contains(q)) return q;
            q = cache.get(q.val);
        }
        return null;
    }
}
