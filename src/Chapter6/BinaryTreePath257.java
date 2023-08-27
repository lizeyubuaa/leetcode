package Chapter6;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePath257 {
    private final List<String> result = new ArrayList<>();
    private final Deque<String> path = new ArrayDeque<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            path.addLast(String.valueOf(root.val));
            result.add(String.join("->", path));
            path.removeLast();
            return result;
        }

        path.addLast(String.valueOf(root.val));
        if (root.left != null) {
            binaryTreePaths(root.left);
        }
        if (root.right != null) {
            binaryTreePaths(root.right);
        }
        path.removeLast();

        return result;
    }
}