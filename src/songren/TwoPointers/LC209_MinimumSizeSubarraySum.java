package songren.TwoPointers;

/**
 * Created by yesongren on 2020/4/13
 * 209. Minimum Size Subarray Sum
 */
public class LC209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;

        int left = 0;
        int right = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        while (right < length) {
            sum += nums[right++];

            while (sum >= s) {
                minSize = Math.min(minSize, right - left);
                sum -= nums[left++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
