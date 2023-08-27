package Chapter6;

import java.util.*;

public class ShortestBridge934 {
    private final int[] direction = new int[]{-1, 0, 1, 0, -1};
    private final Deque<List<Integer>> ocean = new ArrayDeque<>();

    public int shortestBridge(int[][] grid) {
        if (grid.length == 0) return 0;

        endLoop:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 为了找到第一个岛屿和第一个岛屿周边的海域，全部变为2
                    dfs(grid, i, j, ocean);
                    break endLoop;
                }
            }
        }

        int level = 0;
        int current_num;
        List<Integer> current_ocean;
        // BFS
        while (ocean.size() != 0) {
            level += 1;
            current_num = ocean.size();
            while (current_num > 0) {
                // 每次循环会清空一次队列
                current_ocean = ocean.removeFirst();
                current_num--;
                for (int i = 0; i < direction.length - 1; i++) {
                    int x = current_ocean.get(0) + direction[i];
                    int y = current_ocean.get(1) + direction[i + 1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 2) continue;
                    else if (grid[x][y] == 1) return level;
                    else if (grid[x][y] == 0) {
                        grid[x][y] = 2;
                        ocean.addLast(Arrays.asList(x, y));
                    }
                }
            }
        }
        return 0;
    }

    private void dfs(int[][] grid, int a, int b, Deque<List<Integer>> ocean) {
        // 注意对grid[a][b]分情况
        if (grid[a][b] == 2) {
            return;
        }
        // 是海洋
        if (grid[a][b] == 0) {
            ocean.addFirst(Arrays.asList(a, b));
            grid[a][b] = 2;
            return;
        }
        // 是陆地
        grid[a][b] = 2;

        for (int i = 0; i < direction.length - 1; i++) {
            int x = direction[i] + a;
            int y = direction[i + 1] + b;
            if(x >= 0 && y >= 0 && x <= grid.length - 1 && y <= grid[0].length - 1) dfs(grid, x, y, ocean);
        }
    }
}
