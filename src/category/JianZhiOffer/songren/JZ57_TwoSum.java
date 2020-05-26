package category.JianZhiOffer.songren;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yesongren on 2020/5/26
 */
public class JZ57_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[]{-1, -1};
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                res[0] = num;
                res[1] = target - num;
            }
            set.add(num);
        }
        return res;
    }

    public int[] twoSumTwoPointers(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) i++;
            else if (nums[i] + nums[j] > target) j--;
            else return new int[] {nums[i], nums[j]};
        }
        return new int[] {-1, -1};
    }
}
