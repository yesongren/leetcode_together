package category.Daily_Challenge.songren;

/**
 * Created by yesongren on 2020/8/11
 * 130. 被围绕的区域
 */
public class Daily_Aug11 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][col - 1] == 'O') dfs(i, col - 1, board);
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') dfs(0, i, board);
            if (board[row - 1][i] == 'O') dfs(row - 1, i, board);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        int row = board.length, col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col) return;
        if (board[i][j] != 'O') return;
        else board[i][j] = '*';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}
