package src.didi.B_DynamicProgramming;

public class LC213_HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp1 = new int[nums.length];
        dp1[0] = 0;
        dp1[1] = nums[0];

        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];

        for (int i = 1; i < nums.length - 1; i++) {
            dp1[i + 1] = Math.max(dp1[i - 1] + nums[i], dp1[i]);
            dp2[i + 1] = Math.max(dp2[i - 1] + nums[i + 1], dp2[i]);
        }

        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
    }
}
