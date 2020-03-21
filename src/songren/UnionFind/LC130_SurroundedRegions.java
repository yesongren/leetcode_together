package songren.UnionFind;

/**
 * Created by yesongren on 2020/3/21
 * 130. Surrounded Regions
 */
public class LC130_SurroundedRegions {

    public static int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        // check 2 boundary columns
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0 , rows, cols);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1 , rows, cols);
        }

        // check 2 boundary rows
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j , rows, cols);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j , rows, cols);
        }

        // check the whole board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'A';
                if (board[i][j] == 'A') board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int x, int y, int rows, int cols){
        if (x < 0 || x >= rows || y < 0 || y >= cols || board[x][y] != 'O') return;
        board[x][y] = 'A';
        for (int[] dir : dirs) {
            int nei_X = dir[0] + x;
            int nei_Y = dir[1] + y;
            dfs(board, nei_X, nei_Y, rows, cols);
        }
    }
}
