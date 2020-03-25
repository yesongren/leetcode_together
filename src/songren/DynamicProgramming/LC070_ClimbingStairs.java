package songren.DynamicProgramming;

/**
 * Created by yesongren on 2020/3/25
 * 70. Climbing Stairs
 */
public class LC070_ClimbingStairs {
    public int climbStairsRec(int n) {
        if (n < 2) return 1;
        return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    public int climbStairsIter(int n) {
        int first = 1, second = 1;
        for (int i = 1; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int climbStairsDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
