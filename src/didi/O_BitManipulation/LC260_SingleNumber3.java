package src.didi.O_BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC260_SingleNumber3 {
    public int[] singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int slow = 0, fast = 1;
        List<Integer> res = new ArrayList<>();
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                slow += 2;
                fast += 2;
            } else {
                res.add(nums[slow]);
                slow++;
                fast++;
            }
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) res.add(nums[slow]);

        return res.stream().mapToInt(i->i).toArray();
    }

    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) set.remove(n);
            else set.add(n);
        }

        Object[] t = set.toArray();

        int[] result = new int[2];
        result[0] = (int)t[0];
        result[1] = (int)t[1];

        return result;
    }
}
