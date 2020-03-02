package songren.BinarySearch;

/**
 * Created by yesongren on 2020/3/3
 * 35. Search Insert Position
 */
public class LC035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid]==target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
