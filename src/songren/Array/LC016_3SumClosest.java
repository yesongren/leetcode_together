package songren.Array;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/2/24
 * 16. 3Sum Closest
 */
public class LC016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            int a = nums[index];
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int total = a + b + c;
                if (total == target) return target;
                if (Math.abs(total - target) < diff) {
                    res = total;
                    diff = Math.abs(total - target);
                }
                if (total < target) left++;
                if (total > target) right--;
            }
        }
        return res;
    }
}
