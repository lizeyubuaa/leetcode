package Chapter14;

import java.util.ArrayDeque;

public class BottomLeft513 {
    public int findBottomLeftValue(TreeNode root) {
        // BFS
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        // 初始化
        q.addLast(root);
        int result = root.val;

        while (!q.isEmpty()) {
            int size = q.size();
            result = q.getFirst().val;
            while (size > 0){
                TreeNode curr = q.removeFirst();
                size --;
                if (curr.left != null) {
                    q.addLast(curr.left);
                }

                if (curr.right != null) {
                    q.addLast(curr.right);
                }
            }
        }
        return result;
    }
}
