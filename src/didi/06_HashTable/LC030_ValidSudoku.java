package didi.HashTable;

class Solution {
    // Deal with unique use HashSet
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    if(!seen.add(board[i][j] + "seen in row " + i) || //use [i][j]
                            !seen.add(board[i][j] + "seen in column" + j) ||
                            !seen.add(board[i][j] + "seen in boxes" + i / 3 + "-" + j / 3)) return false;
            }
        }

        return true;
    }
}