package Chapter14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StackInorder94 {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> state = new ArrayDeque<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // 根节点不为空或者栈不为空可以进入循环
        while (root != null || !state.isEmpty()) {
            // 遍历
            while (root != null){
                state.addLast(root);
                root = root.left;
            }
            // 访问
            root = state.removeLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


    public List<Integer> inorderTraversal_dfs(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }
}