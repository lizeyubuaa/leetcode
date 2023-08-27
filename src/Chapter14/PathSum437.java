package Chapter14;

public class PathSum437 {
    // pathSum(p,val) 表示p为根节点的树满足条件的路径数目
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // pathSum(p,val)分为两大类，以p为起点和不以p为起点（没p的事情了）
        return rootSum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    // rootSum(p,val) 表示以节点p为起点向下且满足路径总和为val的路径数目
    // targetSum可能为负数
    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        // 单独的一种特殊情况
        if (val == targetSum) {
            ret++;
        }
        // 即使val == targetSum，存在一些正负抵消的节点
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}

