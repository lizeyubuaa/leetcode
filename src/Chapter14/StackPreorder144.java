package Chapter14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class StackPreorder144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> search = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        // 初始化
        search.addLast(root);
        while (!search.isEmpty()) {
            TreeNode current_node = search.removeLast();
            // 访问
            result.add(current_node.val);
            // 遍历
            if (current_node.right != null) search.addLast(current_node.right);
            if (current_node.left != null) search.addLast(current_node.left);
        }
        return result;
    }
}
