package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/3
 * 面试题10- I. 斐波那契数列
 */
public class JZ10_1_FibonacciNumber {

    // DP
    public int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    // 滚动数组
    public int fibOpt(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return n;
        int num1 = 1, num2 = 1;
        for (int i = 3; i <= n; i++) {
            int sum = (num1 + num2) % 1000000007;
            num2 = num1;
            num1 = sum;
        }
        return num1;
    }
}
