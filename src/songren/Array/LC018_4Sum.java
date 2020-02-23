package songren.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yesongren on 2020/2/24
 * 018. 4 Sum
 */
public class LC018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target, int n) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == 2) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int fixedTarget = target - a;
            int[] temp = new int[nums.length -1];
            for (int j = 0; j< nums.length; j++) {
                temp[j] = nums[i + 1];
            }
            List<List<Integer>> fixedResult = fourSum(temp, fixedTarget, n - 1);
            for (List<Integer> res : fixedResult) {
                res.add(a);
                result.add(res);
            }
        }
        return result;
    }
}
