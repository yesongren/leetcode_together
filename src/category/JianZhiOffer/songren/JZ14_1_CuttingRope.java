package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/5
 * 面试题14- I. 剪绳子
 */
public class JZ14_1_CuttingRope {
    private int[] memo;

    public int cuttingRope(int n) {
        memo = new int[n + 1];
        return help(n);
    }

    private int help(int n) {
        if (n <= 2) return 1;
        if (memo[n] > 0) return memo[n];
        int res = 0;
        for (int i = 1; i <= n / 2; i++) {
            int maxLeft = Math.max(i, help(i));
            int maxRight = Math.max(n - i, help(n - i));
            res = Math.max(res, maxLeft * maxRight);
        }
        memo[n] = res;
        return res;
    }
}
