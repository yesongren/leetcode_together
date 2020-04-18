package src.didi.A_Array;

import java.util.Arrays;

class LC031_NextPermutation {
    public void nextPermutation(int[] nums) {
        // 寻找下一个大的数
        if (nums == null || nums.length == 0) return;
        int idx = nums.length - 1;
        int right = nums.length - 2;

        while (right >= 0) {
            if (nums[right] < nums[right + 1]) break;
            right--;
        }

        if (right < 0) {
            Arrays.sort(nums);
            return;
        }

        while (idx > 0) {
            if (nums[idx] > nums[right]) break;
            idx--;
        }

        int tmp = nums[right];
        nums[right] = nums[idx];
        nums[idx] = tmp;

        Arrays.sort(nums, right + 1, nums.length);
    }
}