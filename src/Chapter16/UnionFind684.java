package Chapter16;

public class UnionFind684 {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        // 节点数目 = 边数目
        int n = edges.length;
        // 节点从1开始标号
        parent = new int[n + 1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            // 查找两个节点是否属于同一个连通分量
            if (find(node1) == find(node2)) return edge;
            else union(node1, node2);
        }
        return new int[]{};
    }

    private void union(int node1, int node2) {
        // union两个节点
        parent[find(node1)] = find(node2);
        // parent[find(node2)] = find(node1);
    }

    private int find(int node) {
        if (parent[node] != node) {
            // 递归找到根
            node = find(parent[node]);
        }
        return node;
    }
}