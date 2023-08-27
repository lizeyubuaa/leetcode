package Chapter11;

public class RangeSum2D304 {
    private int[][] image_integral;

    public RangeSum2D304(int[][] matrix) {
        image_integral = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                image_integral[i][j] = matrix[i - 1][j - 1] + image_integral[i][j - 1] + image_integral[i - 1][j] - image_integral[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return image_integral[row2 + 1][col2 + 1] - image_integral[row1][col2 + 1] - image_integral[row2 + 1][col1] + image_integral[row1][col1];
    }
}
