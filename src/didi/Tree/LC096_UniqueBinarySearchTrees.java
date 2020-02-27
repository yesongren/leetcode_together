package didi.Tree;

class Solution {
    // DP (state, init, func, result)
    // func = sum from 0 to i-1 [j]*[i-j-1]
    public int numTrees(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n+1]; // one more space
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {// start at 2
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[i-j-1] * dp[j]);
            }
        }

        return dp[n];
    }
}