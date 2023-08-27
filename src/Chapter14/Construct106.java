package Chapter14;

import java.util.*;

public class Construct106 {
    Map<Integer, Integer> states = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            states.put(inorder[i], i);
        }
        int n = inorder.length;
        return builder(postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode builder(int[] postorder, int in_l, int in_r, int post_l, int post_r) {
        // 固定写法
        if (in_l > in_r || post_l > post_r) {
            return null;
        }

        int root_val = postorder[post_r];
        TreeNode root = new TreeNode(root_val);
        int root_index = states.get(root_val);
        int l_child_num = root_index - in_l;
        root.left = builder(postorder, in_l, root_index - 1, post_l, post_l + l_child_num - 1);
        root.right = builder(postorder, root_index + 1, in_r, post_l + l_child_num, post_r - 1);
        return root;
    }
}