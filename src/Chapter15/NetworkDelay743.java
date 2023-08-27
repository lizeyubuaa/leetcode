package Chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelay743 {
    public int networkDelayTime_ori(int[][] times, int n, int k) {
        // 除2是为了防止溢出
        final int INF = Integer.MAX_VALUE / 2;

        // 数据结构1：记录（单）源节点到所有节点的最短距离
        int[] res = new int[n];
        Arrays.fill(res, INF);

        // 数据结构2：记录两个节点之间的距离
        List<int[]>[] g = new ArrayList[n];
        // 务必逐一初始化
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<int[]>();
        }

        for (int[] time : times) {
            int x = time[0] - 1;
            int y = time[1] - 1;
            int dest = time[2];
            g[x].add(new int[]{y, dest});
        }

        // 数据结构3：用来记录哪些节点是未标记的节点
        boolean[] used = new boolean[n];

        res[k - 1] = 0;
        // 一共需要寻找n次
        for (int i = 0; i < n; i++) {
            int current_unlabeled = -1;
            // step1:寻找当前距离源节点最近的(多次找)、未标记节点
            for (int j = 0; j < n; j++) {
                if (!used[j] && (current_unlabeled == -1 || res[j] < res[current_unlabeled])) {
                    current_unlabeled = j;
                }
            }
            used[current_unlabeled] = true;
            // step2:使用该节点更新所有未标记节点的距离
            for (int[] ints : g[current_unlabeled]) {
                res[ints[0]] = Math.min(res[ints[0]], res[current_unlabeled] + ints[1]);
            }
        }
        return Arrays.stream(res).max().getAsInt() != INF ? Arrays.stream(res).max().getAsInt() : -1;
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        // 除2是为了防止溢出
        final int INF = Integer.MAX_VALUE / 2;

        // 数据结构1：记录（单）源节点到所有节点的最短距离
        int[] res = new int[n];
        Arrays.fill(res, INF);

        // 数据结构2：记录两个节点之间的距离
        List<int[]>[] g = new ArrayList[n];
        // 务必逐一初始化
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<int[]>();
        }

        for (int[] time : times) {
            int x = time[0] - 1;
            int y = time[1] - 1;
            int dest = time[2];
            g[x].add(new int[]{y, dest});
        }

        // 数据结构3：维护节点到源节点的最短距离
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[1] - b[1] : 0);
        // 源节点是k，到自己的最短距离是0
        pq.add(new int[]{k - 1, 0});

        while (pq.size() != 0) {
            int[] tmp = pq.remove();
            int x = tmp[0];
            int dest = tmp[1];
            res[x] = Math.min(res[x], dest);

            // 用当前未标记的节点x去更新其他未标记的节点y
            for (int[] ints : g[x]) {
                int y = ints[0];
                int x_y = ints[1];
                if (res[y] > res[x] + x_y) {
                    res[y] = res[x] + x_y;
                    pq.add(new int[]{y, res[y]});
                }
            }
        }
        return Arrays.stream(res).max().getAsInt() != INF ? Arrays.stream(res).max().getAsInt() : -1;
    }
}
