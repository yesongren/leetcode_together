package didi.greedy;

class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int index = 0, currMax = 0, nextMax = 0, step = 0;

        while(index <= currMax) {
            while(index <= currMax && index <= nums.length - 1) {
                nextMax = Math.max(nums[index] + index, nextMax);
                index++;
            }
            if (currMax >= nums.length - 1) return step;
            currMax = nextMax;
            step++;
        }

        return 0;
    }
}