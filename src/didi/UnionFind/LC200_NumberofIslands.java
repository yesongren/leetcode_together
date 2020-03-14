package didi.unionfind;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null || grid[0].length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) return;

        grid[i][j] = '0';

        if (i < grid.length - 1 && grid[i + 1][j] == '1') helper(grid, i + 1, j);

        if (i > 0 && grid[i - 1][j] == '1') helper(grid, i - 1, j);

        if (j > 0 && grid[i][j - 1] == '1') helper(grid, i, j - 1);

        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') helper(grid, i, j + 1);

    }
}