package category.Daily_Challenge.songren;

/**
 * Created by yesongren on 2020/8/15
 * 546. 移除盒子
 */
public class Daily_Aug15 {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length < 1) {
            return 0;
        }
        int n = boxes.length;
        int[][][] scores = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                scores[i][i][k] = (1 + k) * (1 + k);
            }
        }
        for (int r = 1; r < n; r++) {
            for (int i = 0; i + r < n; i++) {
                int j = i + r;
                for (int k = 0; k <= i; k++) {
                    int result = (1 + k) * (1 + k) + scores[i + 1][j][0];
                    for (int m = i + 1; m <= j; m++) {
                        if (boxes[m] == boxes[i]) {
                            result = Math.max(result, scores[i + 1][m - 1][0] + scores[m][j][k + 1]);
                        }
                    }
                    scores[i][j][k] = result;
                }
            }
        }
        return scores[0][n - 1][0];
    }
}
