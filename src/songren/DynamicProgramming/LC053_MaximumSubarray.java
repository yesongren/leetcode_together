package songren.DynamicProgramming;

/**
 * Created by yesongren on 2020/2/24
 * 53. Maximum Subarray
 *
 * dp
 */
public class LC053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxLocal = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxLocal = Math.max(nums[i], nums[i] + maxLocal);
            global = Math.max(global, maxLocal);
        }
        return global;
    }
}
