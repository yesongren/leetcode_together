package src.didi.B_DynamicProgramming;

class LC053_MaximumSubarray {
    // Brute Force
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            int left = i;
            int sum = 0;

            while (left < nums.length){
                sum += nums[left];
                max = Math.max(sum,max);
                left++;
            }
        }

        return max;
    }
    // DP
    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = max;

        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}