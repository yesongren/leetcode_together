package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/3
 * 面试题10- II. 青蛙跳台阶问题
 */
public class JZ10_2_NumWays {

    // DP
    public int numWays(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    // 优化dp
    public int numWaysOpt(int n) {
        int first = 1, second = 1;
        for (int i = 1; i < n; i++) {
            int third = (first + second) % 1000000007;
            first = second;
            second = third;
        }
        return second;
    }
}
