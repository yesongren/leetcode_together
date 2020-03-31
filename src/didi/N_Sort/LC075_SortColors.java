package didi.sort;

class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1 || nums == null) return;
        int index = 0, first = 0, last = nums.length - 1;
        while(index <= last && nums[index] == 0) index++;
        while(last > 0 && nums[last] == 2) last--;
        first = index;

        while (index <= last) {
            if (nums[index] == 0) {
                switchOrder(nums, first, index);
                first++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                switchOrder(nums, index, last);
                last--;
            }
        }
    }

    private void switchOrder(int[] nums, int first, int last) {
        int tmp = nums[last];
        nums[last] = nums[first];
        nums[first] = tmp;
    }
}