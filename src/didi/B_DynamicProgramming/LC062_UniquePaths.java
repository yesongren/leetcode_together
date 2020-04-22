package src.didi.B_DynamicProgramming;

class LC062_UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m == 0||n == 0) return 0;
        if(m == 1||n == 1) return 1;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) dp[i][0] = 1;
        for (int i = 0; i < m; i++) dp[0][i] = 1;

        for (int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++)
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }

        return dp[n - 1][m - 1];
    }
}