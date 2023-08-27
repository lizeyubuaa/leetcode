package Chapter14;

public class Diameter543 {
    // 需要多次更新
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        // 经过该根节点的直径：左右子树高度的和
        diameter = Math.max(diameter, l + r);
        // 该根节点的高度：左右子树高度的最大值 + 1
        return Math.max(l, r) + 1;
    }
}
