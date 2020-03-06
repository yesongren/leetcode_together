package songren.TwoPointers;

/**
 * Created by yesongren on 2020/3/6
 * 26. Remove Duplicates from Sorted Array
 */
public class LC026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int p = 1;
        for (int q = 1; q < nums.length; q++) {
            if (nums[q] != nums[q - 1]) {
                nums[p++] = nums[q];
            }
        }
        return p;
    }
}
