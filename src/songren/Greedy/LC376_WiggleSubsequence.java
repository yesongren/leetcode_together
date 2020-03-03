package songren.Greedy;

/**
 * Created by yesongren on 2020/3/4
 * 376. Wiggle Subsequence
 */
public class LC376_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums == null ? 0 : nums.length;
        }
        int[][] dp = new int[nums.length + 1][2];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                dp[i + 1][1] = Math.max(dp[i][0] + 1, dp[i][1]);
            } else if (nums[i] - nums[i - 1] < 0) {
                dp[i + 1][0] = Math.max(dp[i][1] + 1, dp[i][0]);
            } else {
                dp[i + 1][1] = dp[i][1];
                dp[i + 1][0] = dp[i][0];
            }
        }
        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][0]) + 1;
    }
}
