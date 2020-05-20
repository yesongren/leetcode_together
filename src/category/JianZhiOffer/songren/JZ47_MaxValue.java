package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/20
 * 面试题47. 礼物的最大价值
 */
public class JZ47_MaxValue {
    public int maxValue(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return dfs(grid, memo, 0, 0, 1);
    }

    public int dfs(int[][] grid, int[][] memo, int i, int j, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        if (k == m + n) return 0;

        int downValue = dfs(grid, memo, i + 1, j, k + 1);
        int rightValue = dfs(grid, memo, i, j + 1, k + 1);

        int res = grid[i][j] + Math.max(downValue, rightValue);

        memo[i][j] = res;

        return res;
    }
}
