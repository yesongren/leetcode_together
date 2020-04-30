package src.didi.A_Array;

public class LC152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int product = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int nextMax = currMax * nums[i];
            int nextMin = currMin * nums[i];

            currMax = Math.max(nums[i], Math.max(nextMax, nextMin));
            currMin = Math.min(nums[i], Math.min(nextMax, nextMin));

            product = Math.max(currMax, product);
        }

        return product;
    }
}
