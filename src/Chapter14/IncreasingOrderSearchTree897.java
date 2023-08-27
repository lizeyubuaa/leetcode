package Chapter14;

public class IncreasingOrderSearchTree897 {
    TreeNode dummy_root = new TreeNode();
    TreeNode res = dummy_root;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        increasingBST(root.left);
        dummy_root.right = new TreeNode(root.val);
        dummy_root = dummy_root.right;
        increasingBST(root.right);
        return res.right;
    }
}
