package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/19
 * 面试题 01.08. 零矩阵
 */
public class JD0108_SetZeros {
    public void setZeroes(int[][] m) {
        int row = m.length, col = m[0].length;
        int[][] tmp = new int[row][col];
        // copy original matrix
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                tmp[i][j] = m[i][j];
            }
        }
        // set zeros
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (tmp[i][j] == 0) {
                    for (int r = 0; r < row; ++r) {
                        m[r][j] = 0;
                    }
                    for (int c = 0; c < col; ++c) {
                        m[i][c] = 0;
                    }
                }
            }
        }
    }
}
