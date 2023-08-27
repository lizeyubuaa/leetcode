package Chapter6;


public class Island695 {
    // 标记节点是否已经访问，所有节点仅允许访问一次
    private int[][] visited;
    private final int[] direction = {-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        Island695 obj = new Island695();
        int[][] test = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(obj.maxAreaOfIsland(test));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int a, int b) {
        // 确认节点是否是陆地
        if (grid[a][b] == 0) return 0;
        // 同样可以起到标记节点是否已经访问的功能
        grid[a][b] = 0;

        int x;
        int y;
        int res = 1;

        // 易错点：最多只能遍历到倒数第二个元素
        for (int i = 0; i < direction.length - 1; i++) {
            x = a + direction[i];
            y = b + direction[i + 1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                res += dfs(grid, x, y);
            }
        }
        return res;
    }
}
