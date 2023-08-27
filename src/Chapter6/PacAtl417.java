package Chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacAtl417 {
    private final Integer[] direction = {-1, 0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights.length == 0) return res;

        boolean[][] canAchievePac = new boolean[heights.length][heights[0].length];
        boolean[][] canAchieveAtl = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            dfs(heights, canAchievePac, i, 0);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, canAchievePac, 0, i);
        }
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, canAchieveAtl, i, heights[0].length - 1);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, canAchieveAtl, heights.length - 1, i);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                // 添加元素的方式
                if (canAchievePac[i][j] && canAchieveAtl[i][j]) res.add(List.of(i, j));
            }
        }
        return res;
    }

    public void dfs(int[][] heights, boolean[][] canAchieve, int a, int b) {
        int x;
        int y;
        if (canAchieve[a][b]) return;
        else{
            canAchieve[a][b] = true;
        }

        for (int i = 0; i < direction.length - 1; i++) {
            x = a + direction[i];
            y = b + direction[i + 1];
            if (x >= 0 && y >= 0 && x < heights.length && y < heights[0].length && heights[x][y] >= heights[a][b]) {
                dfs(heights, canAchieve, x, y);
            }
        }
    }
}