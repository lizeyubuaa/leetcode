package Chapter15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class ToPoSort210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 处理入度为0的节点，上课
        Deque<Integer> topo_queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        // 邻接链表
        ArrayList<Integer>[] adj_list = new ArrayList[numCourses];
        int[] in_degree = new int[numCourses];
        // 初始化
        // Arrays.fill(adj_list, new ArrayList<Integer>());
        for (int i = 0; i < numCourses; i++) {
            adj_list[i] = new ArrayList<Integer>();
        }
        Arrays.fill(in_degree, 0);

        for (int[] prerequisite : prerequisites) {
            int cls1 = prerequisite[0];
            int cls2 = prerequisite[1];
            adj_list[cls2].add(cls1);
            in_degree[cls1] += 1;
        }

        for (int i = 0; i < numCourses; i++) {
            if (in_degree[i] == 0) topo_queue.addLast(i);
        }

        while (!topo_queue.isEmpty()) {
            int current = topo_queue.removeFirst();
            // 往result里存
            result.add(current);
            adj_list[current].forEach(x -> {
                in_degree[x]--;
                // 往result里存
                if (in_degree[x] == 0) topo_queue.addLast(x);
            });
        }
        if (result.size() == numCourses) return result.stream().mapToInt(Integer::intValue).toArray();
        else return new int[]{};
    }
}
