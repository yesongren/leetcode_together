package didi;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2], sum; // bug 1 cannot use Integer.MAX_VALUE (overflow)
        for (int i = 0; i < nums.length-2; i++){
            int left = i+1, right = nums.length-1;
            while (left < right){
                sum = nums[left] + nums[right] + nums[i];
                if (sum > target) right--;
                else left++;
                if (Math.abs(sum-target) < Math.abs(result-target)) result = sum; // bug 1
            }
        }
        return result;
    }
}
