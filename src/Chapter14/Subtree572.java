package Chapter14;

public class Subtree572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) return true;
        if (rootA == null || rootB == null) return false;
        return rootA.val == rootB.val && isSame(rootA.left, rootB.left) && isSame(rootA.right, rootB.right);
    }
}