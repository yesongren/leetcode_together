package src.category.JianZhiOffer.didi;

import java.util.HashSet;

public class JZ57_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];
        for (int num : nums) {
            int rest = target - num;
            if (set.contains(rest)) {
                result[1] = num;
                result[0] = rest;
                return result;
            } else
                set.add(num);
        }
        return result;
    }
}
