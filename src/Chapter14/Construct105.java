package Chapter14;

import java.util.HashMap;

public class Construct105 {
    // node_value:index
    private final HashMap<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] preorder, int pre_l, int pre_r, int in_l, int in_r) {
        if (pre_l > pre_r || in_l > in_r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_l]);

        int root_index = inOrderMap.get(root.val);
        int left_child_num = root_index - in_l;
        root.left = helper(preorder, pre_l + 1, pre_l + left_child_num, in_l, root_index - 1);
        root.right = helper(preorder, pre_l + left_child_num + 1, pre_r, root_index + 1, in_r);
        return root;
    }
}
