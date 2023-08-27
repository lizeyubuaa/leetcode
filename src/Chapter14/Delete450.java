package Chapter14;

public class Delete450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 减少遍历次数，因为只有一个给定值，否则左右子树都要寻找
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        else{
            // 被删除的节点是叶节点
            if (root.left == null && root.right == null) {
                return null;
            }
            // 被删除的节点是只有一个孩子节点
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // 被删除的节点是有两个孩子节点
            // 先右后左
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
    }
}