package Chapter14;

public class Construct889 {
    int[] preorder;
    int[] postorder;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        return builder(0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode builder(int pre_l, int pre_r, int post_l, int post_r) {
        if(pre_l > pre_r || post_l > post_r) return null;
        TreeNode root = new TreeNode(preorder[pre_l]);
        int left_child_num = 0;
        while (true) {
            if (postorder[post_l + left_child_num - 1] == preorder[pre_l + 1]) {
                break;
            }
            left_child_num++;
        }
        root.left = builder(pre_l + 1, pre_l + left_child_num, post_l, post_l + left_child_num - 1);
        root.right = builder(pre_l + left_child_num + 1, pre_r, post_l + left_child_num, post_r - 1);
        return root;
    }
}