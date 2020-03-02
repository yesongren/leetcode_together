package didi.BinarySearch;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1,-1};
        if (nums.length == 0 || nums == null) return result;

        int leftIndex = -1, rightIndex = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) leftIndex = mid; // sepreate
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }

        left = 0; right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) rightIndex = mid; //
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        result[0] = leftIndex;
        result[1] = rightIndex;

        return result;
    }
}