package Chapter14;

public class Balanced110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >=0;
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        int left_height = height(root.left);
        // 提前return, 剪枝
        if(left_height == -1) return -1;
        int right_height = height(root.right);
        // 提前return, 剪枝
        if(right_height == -1) return -1;
        // 再次剪枝
        if(Math.abs(left_height - right_height) > 1) return -1;
        return Math.max(left_height, right_height) + 1;
    }

    public boolean isBalanced_top2down(TreeNode root) {
        if (root == null) return true;
        else if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);

    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
