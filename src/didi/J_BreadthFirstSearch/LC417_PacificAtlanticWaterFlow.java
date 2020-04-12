package src.didi.J_BreadthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC417_PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][]Pacific = new boolean[n][m];
        boolean[][]Atlantic = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            dfs(matrix, Pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, Atlantic, Integer.MIN_VALUE, i, m - 1);
        }

        for(int i = 0; i < m; i++) {
            dfs(matrix, Pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, Atlantic, Integer.MIN_VALUE, n - 1, i);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(Pacific[i][j] && Atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private static int[] dx = {0,-1,0,1};
    private static int[] dy = {1,0,-1,0};

    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] < height || visited[x][y]) return;
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            dfs(matrix, visited, matrix[x][y], x + dx[i], y + dy[i]);
        }
    }
}
