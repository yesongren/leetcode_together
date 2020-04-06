package songren.BinarySearch;

/**
 * Created by yesongren on 2020/4/6
 * 81. Search in Rotated Sorted Array II
 */
public class LC081_SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        if (nums.length == 0)
            return false;
        while (mid < right && nums[mid] <= nums[++mid]) ;
        if (target < nums[0])
            left = mid;
        else
            right = mid--;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;

    }
}
