package Chapter14;

public class SumOfLeft404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + ((root.left != null && root.left.left == null && root.left.right == null) ? root.left.val : 0);
    }
    
    int result = 0;

    public int sumOfLeftLeaves_ori(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) result += root.left.val;
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return result;
    }
}