package src.didi.B_DynamicProgramming;

public class LC221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;

        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == '1') {
                dp[r][0] = 1;
                max = 1;
            }
        }

        for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == '1') {
                dp[0][c] = 1;
                max = 1;
            }
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == '1') {
                    dp[r][c] = Math.min(dp[r][c - 1], Math.min(dp[r - 1][c - 1], dp[r - 1][c])) + 1;
                    max = Math.max(max, dp[r][c]);
                }
            }
        }

        return max * max;
    }
}
