package Chapter14;

public class Merge617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root;
        if (root1 != null && root2 != null) {
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        }
        else if (root1 != null) {
            return root1;
        }
        else if (root2 != null) {
            return root2;
        }
        else {
            root = null;
        }
        return root;
    }
}
