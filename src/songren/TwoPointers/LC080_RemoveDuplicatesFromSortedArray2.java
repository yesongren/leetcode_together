package songren.TwoPointers;

/**
 * Created by yesongren on 2020/4/13
 * 80. Remove Duplicates from Sorted Array II
 */
public class LC080_RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int fast = 2;
        int slow = 1;
        int max = 2;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - max + 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
