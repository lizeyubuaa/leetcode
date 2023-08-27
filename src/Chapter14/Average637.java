package Chapter14;

import java.util.*;

public class Average637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> search = new ArrayDeque<>();
        if (root == null) return new ArrayList<>(0);
        // 初始化
        search.add(root);
        ArrayList<Double> result = new ArrayList<>();

        TreeNode current_node;
        while (search.size() != 0) {
            ArrayList<Long> current_level = new ArrayList<>();
            int current_number = search.size();
            while (current_number != 0) {
                current_node = search.removeFirst();
                current_level.add((long) current_node.val);
                if (current_node.left != null) search.addLast(current_node.left);
                if (current_node.right != null) search.addLast(current_node.right);
                current_number--;
            }
            double current_avg = (double) current_level.stream().reduce(0L, Long::sum) / current_level.size();
            result.add(current_avg);
        }
        return result;
    }
}
