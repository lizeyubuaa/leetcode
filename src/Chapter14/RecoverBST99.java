package Chapter14;

public class RecoverBST99 {
    private TreeNode mistake1;
    private TreeNode mistake2;
    private TreeNode pre;

    // 关键特性：二叉查找树中序遍历的结果是有序数组，题目规定最多需要交换一次即可
    // 交换的分为相邻元素和不相邻元素
    public void recoverTree(TreeNode root) {
        find(root);
        if (mistake1 != null && mistake2 != null) {
            int temp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = temp;
        }
    }

    public void find(TreeNode root) {
        if (root == null) return;
        find(root.left);
        if (pre != null && pre.val > root.val) {
            if (mistake1 == null && mistake2 == null) {
                mistake1 = pre;
            }
            mistake2 = root;
        }
        pre = root;
        find(root.right);
    }
}
