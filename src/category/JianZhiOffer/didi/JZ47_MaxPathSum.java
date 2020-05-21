package src.category.JianZhiOffer.didi;

public class JZ47_MaxPathSum {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                dp[r][c] += grid[r][c];
                if (r > 0 && c > 0) dp[r][c] += Math.max(dp[r - 1][c], dp[r][c - 1]);
                else if (r > 0) dp[r][c] += dp[r - 1][c];
                else if (c > 0) dp[r][c] += dp[r][c - 1];
            }
        }

        return dp[row - 1][col - 1];
    }
}
