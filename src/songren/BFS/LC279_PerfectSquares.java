package songren.BFS;

/**
 * Created by yesongren on 2020/4/10
 * 279. Perfect Squares
 */
public class LC279_PerfectSquares {
    public int numSquaresDP(int n) {
        int[] d = new int[n + 1];
        d[0] = 0;
        for (int i = 1; i <= n; ++i) {
            d[i] = i;
            for (int j = 1; j * j <= i; ++j)
                d[i] = Math.min(d[i], d[i - j * j] + 1);
        }
        return d[n];
    }
}
