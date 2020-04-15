package src.didi.M_Backtracking;

public class LC079_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;

        int row = board.length, col = board[0].length;
        char start = word.charAt(0);
        boolean[][] visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == start && Helper(board, r, c, visited, word, "")) return true; // sb should be empty
            }
        }

        return false;
    }

    private boolean Helper(char[][] board, int r, int c, boolean[][] visited, String word, String sb) {
        if (sb.equals(word)) return true;

        boolean outBound = r < 0 || r >= board.length || c < 0 || c >= board[0].length;
        char target = word.charAt(sb.length());

        if (!outBound && !visited[r][c] && board[r][c] == target) {
            visited[r][c] = true;

            boolean left = Helper(board, r, c - 1, visited, word, sb + target);
            boolean right = Helper(board, r, c + 1, visited, word, sb + target);
            boolean top = Helper(board, r  - 1, c, visited, word, sb + target);
            boolean bottom = Helper(board, r + 1, c, visited, word, sb + target);

            boolean res = left || right || top || bottom;
            if (!res) visited[r][c] = false;
            return res;
        }

        return false;
    }
}
