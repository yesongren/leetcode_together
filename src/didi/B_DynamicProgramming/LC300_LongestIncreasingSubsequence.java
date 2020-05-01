package src.didi.B_DynamicProgramming;

import java.util.Arrays;

public class LC300_LongestIncreasingSubsequence {
    public int lengthOfLIS1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int currLen = 0;

        for (int num : nums) {
            int i;
            for (i = 0; i < currLen; i++) {
                if (tails[i] >= num) {
                    tails[i] = num;
                    break;
                }
            }

            if (i == currLen) {
                currLen++;
                tails[i] = num;
            }
        }

        return currLen;
    }
}
