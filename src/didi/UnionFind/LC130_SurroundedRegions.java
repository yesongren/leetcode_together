package didi.unionfind;

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int row = board.length;
        int col = board[0].length;

        // left right column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][col - 1] == 'O') helper(board, i, col - 1);
        }

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') helper(board, 0, i);
            if (board[row - 1][i] == 'O') helper(board, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'V') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X'; // not if (prev if will change i,j)
            }
        }
    }

    private void helper(char[][] board, int row, int col) {
        if (row > board.length - 1 || row < 0 || col > board[0].length || col < 0) return;

        board[row][col] = 'V';

        if (row > 0 && board[row - 1][col] == 'O') helper(board, row - 1, col);

        if (row < board.length - 1 && board[row + 1][col] == 'O') helper(board, row + 1, col);

        if (col > 0 && board[row][col - 1] == 'O') helper(board, row, col - 1);

        if (col < board[0].length - 1 && board[row][col + 1] == 'O') helper(board, row, col + 1);

    }
}