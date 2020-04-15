package songren.Backtracking;

/**
 * Created by yesongren on 2020/4/15
 * 79. Word Search
 */
public class LC079_WordSearch {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        int rows = board.length;
        int cols = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || word.charAt(index) != board[i][j]) return false;
        char tmp = board[i][j];
        board[i][j] = '*';
        boolean found = dfs(board, i, j - 1, word, index + 1) ||
                        dfs(board, i + 1, j, word, index + 1) ||
                        dfs(board, i, j + 1, word, index + 1) ||
                        dfs(board, i - 1, j, word, index + 1);
        board[i][j] = tmp;
        return found;
    }
}
