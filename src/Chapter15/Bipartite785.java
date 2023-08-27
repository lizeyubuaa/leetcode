package Chapter15;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class Bipartite785 {
    public boolean isBipartite(int[][] graph) {
        int[] states = new int[graph.length];
        Deque<Integer> search_queue = new ArrayDeque<>();
        // 初始化，0表示未检查、未遍历
        Arrays.fill(states, 0);

        for (int i = 0; i < graph.length; i++) {
            // 设置为1
            if (states[i] == 0) {
                states[i] = 1;
                // 只有为0才需要搜索
                search_queue.addLast(i);
            }
            // 不必每次给queue重新设为空
            while (!search_queue.isEmpty()) {
                int head = search_queue.removeFirst();
                // 注意for循环，不是fori循环
                for (int neighbor : graph[head]) {
                    // 设置为与head节点不同的颜色
                    if (states[neighbor] == 0) {
                        states[neighbor] = states[head] == 1 ? 2 : 1;
                        // 只有为0才需要搜索
                        search_queue.addLast(neighbor);
                    }
                    else if (states[head] == states[neighbor]) return false;
                }
            }
        }
        return true;
    }
}
