package Chapter14;

import java.util.*;
import java.util.stream.Collectors;

public class Delete1110 {
    // 去重，快速查看当前节点是否需要被删除
    HashSet<Integer> delete;
    List<TreeNode> forest;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        delete = Arrays.stream(to_delete).boxed().collect(Collectors.toCollection(HashSet::new));
        forest = new ArrayList<>();
        root = helper(root);
        // 父节点的添加
        if (root != null) forest.add(root);
        return forest;
    }

    // 为了不传入父节点信息，在父节点处处理左右节点的删除过程
    // 如果该节点被删除，返回null，否则返回该节点
    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        // 先处理左右节点
        root.left = helper(root.left);
        root.right = helper(root.right);
        // 只有在父节点被删掉时，才会有forest添加操作
        if (delete.contains(root.val)) {
            // 检查是否被删掉了
            // 左节点的添加
            if (root.left != null) forest.add(root.left);
            // 检查是否被删掉了
            // 右节点的添加
            if (root.right != null) forest.add(root.right);
            // 删掉root
            root = null;
        }
        return root;
    }
}
