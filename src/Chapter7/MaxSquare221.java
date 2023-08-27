package Chapter7;

import java.util.Arrays;
import java.util.Collections;

public class MaxSquare221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int value = 0;
        if (m == 0) return 0;
        int[][] states = new int[m][n];

        // 初始化
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    states[i][j] = 1;
                    // 只需要调整一次
                    value = 1;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // 充要条件
                if (matrix[i][j] == '1' &&matrix[i - 1][j] == '1' && matrix[i - 1][j - 1] == '1' && matrix[i][j - 1] == '1') {
                    // 要取一次最小
                    states[i][j] = Collections.min(Arrays.asList(states[i - 1][j], states[i - 1][j - 1], states[i][j - 1])) + 1;
                    value = Math.max(value, states[i][j]);
                }
            }
        }
        // 返回的是面积
        return value * value;
    }
}