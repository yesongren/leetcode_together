package songren.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yesongren on 2020/4/10
 * 417. Pacific Atlantic Water Flow
 */
public class LC417_PacificAtlanticWaterFlow {
    public static int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] Pacific = new boolean[rows][cols];
        boolean[][] Atlantic = new boolean[rows][cols];

        // the first row --> Pacific
        // last rows --> Atlantic
        for (int i = 0; i < rows; i++) {
            dfs(matrix, Pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, Atlantic, Integer.MIN_VALUE, rows - 1, i);
        }

        // the first column --> Pacific
        // the last column --> Atlantic
        for (int i = 0; i < cols; i++) {
            dfs(matrix, Pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, Atlantic, Integer.MIN_VALUE, i, cols - 1);
        }

        // Pacific[i][j] && Atlantic[i][j]: flow to both the Pacific and Atlantic ocean.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Pacific[i][j] && Atlantic[i][j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.addAll(Arrays.asList(i, j));
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || matrix[x][y] < height) {
            return;
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nei_X = dir[0] + x;
            int nei_Y = dir[1] + y;
            dfs(matrix, visited, matrix[x][y], nei_X, nei_Y);
        }
    }
}
