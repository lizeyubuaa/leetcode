package Chapter14;

public class Minimum530 {
    int pre = -1;
    int res = Integer.MAX_VALUE / 2;
    public int getMinimumDifference(TreeNode root) {
        if(root != null){
            getMinimumDifference(root.left);
            if (pre != -1) {
                res = Math.min(res, root.val - pre);
            }
            pre = root.val;
            getMinimumDifference(root.right);
        }
        return res;
    }
}
