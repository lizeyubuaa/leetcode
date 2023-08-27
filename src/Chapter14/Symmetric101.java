package Chapter14;

public class Symmetric101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    // 四步法
    // 方法重载
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        // 都为空
        if (left == null && right == null) return true;
        // 一个空，一个不为空
        else if (left == null || right == null) return false;
        // 值不相等
        else if (left.val != right.val) return false;
        // 递归调用
        else return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
