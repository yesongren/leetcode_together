package songren.HashTable;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/3/31
 * 217. Contains Duplicate
 */
public class LC217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
