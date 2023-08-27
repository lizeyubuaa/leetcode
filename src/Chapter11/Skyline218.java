package Chapter11;

import java.util.*;


public class Skyline218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 第 1 步：预处理
        // 「关键点」一定在边界，即buildingPoints里
        // 「关键点」出现在 从「竖直方向」转向「水平方向」的地方，从「水平方向」到「竖直方向」不产生关键点
        // 规则 1：如果是「从下到上」转向「水平方向」，纵坐标最大的点是关键点；
        // 规则 2：如果是「从上到下」转向「水平方向」，纵坐标第二大的点是关键点。
        List<int[]> buildingPoints = new ArrayList<>();
        for (int[] b : buildings) {
            // 负号表示左边高度的转折点
            buildingPoints.add(new int[]{b[0], -b[2]});
            buildingPoints.add(new int[]{b[1], b[2]});
        }

        // 第 2 步：按照横坐标排序，横坐标相同的时候，高度高的在前面
        buildingPoints.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            else {
                // 注意：这里因为左端点传进去的时候，数值是负的，在比较的时候还按照升序排序
                return a[1] - b[1];
            }
        });

        // 第 3 步：扫描
        // 优先队列，存高度，扫描过程动态计算出结果
        // 变成大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 哈希表，记录「延迟删除」的元素，key 为元素（高度），value 为需要删除的次数
        Map<Integer, Integer> delayed = new HashMap<>();

        // 最开始的时候，需要产生高度差，所以需要加上一个高度为 0，宽度为 0 的矩形
        pq.offer(0);
        // 为了计算高度差，需要保存之前最高的高度
        int lastHeight = 0;
        List<List<Integer>> res = new ArrayList<>();
        // 开始扫描
        for (int[] buildingPoint : buildingPoints) {
            if (buildingPoint[1] < 0) {
                // 说明此时是「从下到上」，纵坐标参与选拔最大值，请见「规则 1」
                pq.offer(-buildingPoint[1]);
            }
            else {
                // 自上到下需要返回第二大元素
                // 不是真的删除 buildingPoint[1]，把它放进 delayed，等到堆顶元素是 buildingPoint[1] 的时候，才真的删除
                delayed.put(buildingPoint[1], delayed.getOrDefault(buildingPoint[1], 0) + 1);
            }

            // 如果堆顶元素在延迟删除集合中，才真正删除，这一步可能执行多次，所以放在 while 中
            // while (true) 都是可以的，因为 maxHeap 一定不会为空
            while (!pq.isEmpty()) {
                int curHeight = pq.peek();
                if (delayed.containsKey(curHeight)) {
                    delayed.put(curHeight, delayed.get(curHeight) - 1);
                    if (delayed.get(curHeight) == 0) {
                        // 正常删除元素的成本过高（线性查找O(N)，然后删除O(LogN)）
                        // 需要等到它上浮到堆顶的时候才删除；
                        delayed.remove(curHeight);
                    }
                    pq.poll();
                }
                // 直到找到一个不是待删除的元素
                else {
                    break;
                }
            }

            // 注意这里不需要删除栈顶元素
            int curHeight = pq.peek();
            // 有高度差，才有关键点出现
            if (curHeight != lastHeight) {
                // 正在扫过的左端点的值
                res.add(Arrays.asList(buildingPoint[0], curHeight));
                // 当前高度成为计算高度差的标准
                lastHeight = curHeight;
            }
        }
        return res;
    }
}