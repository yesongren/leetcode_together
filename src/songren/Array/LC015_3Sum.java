package songren.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yesongren on 2020/2/24
 * 015. 3 Sum
 *
 * two pointers
 */
public class LC015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int index = 0; index < nums.length; index++) {
            int a = nums[index];
            if (index >= 1 && nums[index - 1] == a) {  // notice the boundary: index - 1
                continue;
            }
            int left = index + 1;  // left pointer is the next index of 'a'
            int right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int total = a + b + c;
                if (total < 0) {
                    left++;
                } else if (total > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(a, b, c));
                    while (left < right && b == nums[left + 1]) {  // skip the repeated elements
                        left++;
                    }
                    while (left < right && c == nums[right - 1]) {  // the same as above
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
