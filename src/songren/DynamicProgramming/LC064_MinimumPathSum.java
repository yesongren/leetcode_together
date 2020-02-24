package songren.DynamicProgramming;

/**
 * Created by yesongren on 2020/2/25
 * 64. Minimum Path Sum
 *
 * from top to btm
 */
public class LC064_MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[row - 1].length;
        int[][] res = new int[row][col];
        res[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];

        }
        for (int j = 1; j < col; j++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++) {
                res[i][j] = Math.min(res[i][j - 1], res[i - 1][j]) + grid[i][j];
            }
        return res[row - 1][col - 1];

    }
}
