package songren.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yesongren on 2020/2/29
 * 136. Single Number
 */
public class LC136_SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                single -= nums[i];
                set.remove(nums[i]);
            }
            else {
                single += nums[i];
                set.add(nums[i]);
            }
        }
        return single;
    }
}
