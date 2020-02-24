package songren.DynamicProgramming;

/**
 * Created by yesongren on 2020/2/25
 * 63. Unique Paths II
 *
 * dp
 */
public class LC063_UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length; // 行
        int col = obstacleGrid[0].length; //列
        int[][] matric = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matric[i][j] = 0;
            }
        }
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                matric[0][i] = 1;
            }
        }
        for (int j = 0; j < row; j++) {
            if (obstacleGrid[j][0] == 1) {
                break;
            } else {
                matric[j][0] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                } else {
                    matric[i][j] = matric[i - 1][j] + matric[i][j - 1];
                }
            }
        }
        return matric[row - 1][col - 1];
    }
}
