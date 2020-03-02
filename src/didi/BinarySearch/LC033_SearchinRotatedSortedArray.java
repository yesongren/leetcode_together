package didi.BinarySearch;

class Solution {
    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            if (nums[i] > target) return i;
        }
        return nums.length;
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;

        while(low < high) {
            int mid = low + (high - low) / 2; //
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }

        return low;
    }
}