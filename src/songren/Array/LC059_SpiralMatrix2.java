package songren.Array;

/**
 * Created by yesongren on 2020/3/24
 * 59. Spiral Matrix II
 */
public class LC059_SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1, top = 0, right = n - 1, bottom = n - 1, left = 0;
        while (num <= n * n) {
            for (int i = left; i <= right; i++) res[top][i] = num++;
            top++;
            for (int i = top; i <= bottom; i++) res[i][right] = num++;
            right--;
            for (int i = right; i >= left; i--) res[bottom][i] = num++;
            bottom--;
            for (int i = bottom; i >= top; i--) res[i][left] = num++;
            left++;
        }
        return res;
    }
}

