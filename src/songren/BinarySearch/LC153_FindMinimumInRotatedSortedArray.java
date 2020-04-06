package songren.BinarySearch;

/**
 * Created by yesongren on 2020/4/6
 * 153. Find Minimum in Rotated Sorted Array
 */
public class LC153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int target = nums[nums.length - 1];
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return nums[l];
    }
}
