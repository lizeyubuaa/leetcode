package Chapter6;

public class SurroundedRegion130 {
    private boolean[][] visited;
    private final int[] direction = {-1, 0, 1, 0, -1};


    public void solve(char[][] board) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        int x;
        int y;
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && !visited[i][j] && board[i][j] == 'O') {
            visited[i][j] = true;
            for (int m = 0; m < direction.length - 1; m++) {
                x = i + direction[m];
                y = j + direction[m + 1];
                dfs(board, x, y);
            }
        }
        else {
            return;
        }
    }
}
