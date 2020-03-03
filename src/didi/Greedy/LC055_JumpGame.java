package didi.greedy;

class Solution {
    // Brute Force
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        return BF(nums, 0);
    }

    private boolean BF(int[] nums, int index) {
        if (index == nums.length - 1) return true;

        int limit = Math.min(index + nums[index], nums.length - 1);

        for (int i = index + 1; i <= limit; i++) {
            if (BF(nums, i)) return true;
        }

        return false;
    }

    // Greedy, keep max reach
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        int reach = 0;

        for (int i = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(nums[i] + i, reach);
            if (reach >= nums.length - 1) return true;
        }

        return false;
    }
}