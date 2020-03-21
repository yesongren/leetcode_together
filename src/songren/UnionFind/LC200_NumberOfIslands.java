package songren.UnionFind;

/**
 * Created by yesongren on 2020/3/21
 * 200. Number of Islands
 */
public class LC200_NumberOfIslands {
    private final static int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') cnt++;
                dfs(grid, i, j, rows, cols);
            }
        }
        return cnt;
    }

    public void dfs(char grid[][], int x, int y, int rows, int cols) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int[] dir : dirs) {
            int nei_X = dir[0] + x;
            int nei_Y = dir[1] + y;
            dfs(grid, nei_X, nei_Y, rows, cols);
        }
    }
}
