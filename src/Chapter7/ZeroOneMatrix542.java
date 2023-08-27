package Chapter7;

import java.util.Arrays;

public class ZeroOneMatrix542 {
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0) return new int[][]{};
        int m = mat.length;
        int n = mat[0].length;
        int[][] states = new int[m][n];
        for (int[] ints : states) {
            Arrays.fill(ints, 9999);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) states[i][j] = 0;
                if (i > 0) {
                    states[i][j] = Math.min(states[i][j], states[i - 1][j] + 1);
                }
                if (j > 0) {
                    states[i][j] = Math.min(states[i][j], states[i][j - 1] + 1);
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i != m - 1) {
                    states[i][j] = Math.min(states[i][j], states[i + 1][j] + 1);
                }
                if (j != n - 1) {
                    states[i][j] = Math.min(states[i][j], states[i][j + 1] + 1);
                }
            }
        }
        return states;
    }
}
