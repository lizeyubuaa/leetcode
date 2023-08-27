package Chapter6;

public class WordSearch79 {
    private final int[] direction = new int[]{-1, 0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < used[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if (backTrack(board, word, i, j, 1, used)) return true;
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean backTrack(char[][] board, String word, int a, int b, int len, boolean[][] used) {
        if (len == word.length()) return true;

        for (int i = 0; i < direction.length - 1; i++) {
            int x = a + direction[i];
            int y = b + direction[i + 1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == word.charAt(len) && !used[x][y]) {
                used[x][y] = true;
                if (backTrack(board, word, x, y, len + 1, used)) return true;
                used[x][y] = false;
            }
        }
        return false;
    }
}
