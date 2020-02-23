package songren.Array;

import java.util.HashMap;

/**
 * Created by yesongren on 2020/2/23
 * 001. Two Sum
 *
 * HashMap: key-value of the elements in array
 *          value-index of the elements in array
 */
public class LC001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[] {-1, -1};
        int[] res = new int[] {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                res[0] = map.get(complement);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
