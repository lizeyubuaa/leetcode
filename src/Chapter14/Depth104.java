package Chapter14;

public class Depth104 {
    public int maxDepth(TreeNode root) {
        if(root == null)   return 0;
        else return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
