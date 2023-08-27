package Chapter14;

public class ConvertGreaterTree538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            // 反序中序遍历
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
