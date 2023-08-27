package Chapter14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StackPostorder145 {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> state = new ArrayDeque<>();
    TreeNode prev = null;

    public List<Integer> postorderTraversal(TreeNode root) {
        // 根节点不为空或者栈不为空可以进入循环
        while (root != null || !state.isEmpty()) {
            // 遍历
            while (root != null) {
                state.addLast(root);
                root = root.left;
            }
            root = state.removeLast();
            // 遍历
            if (root.right != null && root.right != prev) {
                // 放回根节点，继续开始遍历
                state.addLast(root);
                root = root.right;
            }
            // 访问
            else{
                res.add(root.val);
                prev = root;
                root = null;
            }
        }
        return res;
    }
}
