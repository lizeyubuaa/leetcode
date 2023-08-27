package Chapter11;

import java.util.*;

public class Reconstruct332 {
    private final HashMap<String, PriorityQueue<String>> pairs = new HashMap<>();
    private final List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 初始化
        for (List<String> ticket : tickets) {
            if (pairs.containsKey(ticket.get(0))) pairs.get(ticket.get(0)).add(ticket.get(1));
            else {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(ticket.get(1));
                pairs.put(ticket.get(0), pq);
            }
        }
        // Hierholzer算法用于在连通图中寻找欧拉路径，其流程如下：
        // 从起点出发，进行深度优先搜索。
        // 每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
        // 如果没有可移动的路径，则将所在节点加入到栈中，并返回。
        // dfs
        String current = "JFK";
        dfs(current);
        Collections.reverse(result);
        return result;
    }

    public void dfs(String current) {
        while (pairs.containsKey(current) && pairs.get(current).size() != 0) {
            String tmp = pairs.get(current).poll();
            dfs(tmp);
        }
        result.add(current);
    }
}
