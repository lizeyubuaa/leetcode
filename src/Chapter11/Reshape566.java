package Chapter11;

public class Reshape566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length == 0 || mat.length * mat[0].length != r * c) return mat;
        int[][] res = new int[r][c];
        for (int x = 0; x < r * c; x++) {
            res[x / c][x % c] = mat[x / mat[0].length][x % mat[0].length];
        }
        return res;
    }
}

//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                int a = (i * c + j) / mat[0].length;
//                int b = (i * c + j) % mat[0].length;
//                res[i][j] = mat[a][b];
//            }
//        }