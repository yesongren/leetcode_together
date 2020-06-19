package category.MianShiJinDian.songren;

/**
 * Created by yesongren on 2020/6/19
 * 面试题 01.07. 旋转矩阵
 */
public class JD0107_RotateMatrix {
    public void rotate(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) return;
        int n = m.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n/2; ++j) {
                int tmp = m[i][j];
                m[i][j] = m[i][n-1-j];
                m[i][n-1-j] = tmp;
            }
        }
    }
}
