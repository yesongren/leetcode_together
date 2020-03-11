package songren.Tree;

/**
 * Created by yesongren on 2020/2/28
 * 96. Unique Binary Search Trees
 */
public class LC096_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        return getAns(1, n);
    }

    public int getAns(int start, int end) {
        int ans = 0;
        if (start >= end) return 1;
        for (int i = start; i <= end; i++) {
            int leftNum = getAns(start, i - 1);
            int rightNum = getAns(i + 1, end);
            ans += leftNum * rightNum;
        }
        return ans;
    }

    /**
     * dp
     * Time: O(n^2), Space: O(n)
     */
    public int numTreesDP(int n) {
        if (n < 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[j - 1] * dp[i - j];  // dp[i]表示 i 个递增的数字能构成的BST的数量
            }
        }
        return dp[n];
    }

    /**
     * Catalan Number
     * Time: O(n), Space: O(1)
     */
    public int numTreesCatalan(int n) {
        if (n < 0) return 0;
        long result = 1;
        for (int k = 1; k <= n; ++k)
            result = result * (n + k) / k;
        return (int) (result / (n + 1));
    }
}
