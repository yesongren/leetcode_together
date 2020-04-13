package src.didi.K_TwoPointers;

public class LC080_RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 1;
        for (int j = 2; j < nums.length; j++) {
            if (nums[i - 1] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
