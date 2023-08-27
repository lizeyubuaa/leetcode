package Chapter7;

public class PathSum64 {
    public int minPathSum(int[][] grid) {
        int[][] states = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) states[i][j] = grid[i][j];
                else if (i == 0) states[i][j] = states[i][j - 1] + grid[i][j];
                else if (j == 0) states[i][j] = states[i - 1][j] + grid[i][j];
                else {
                    states[i][j] = Math.min(states[i - 1][j], states[i][j - 1]) + grid[i][j];
                }
            }
        }
        return states[grid.length - 1][grid[0].length - 1];
    }
}
