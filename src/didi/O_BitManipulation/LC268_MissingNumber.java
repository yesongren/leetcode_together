package src.didi.O_BitManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC268_MissingNumber {
    public int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) set.add(i);
        for (int i : nums) set.remove(i);
        return set.stream().findFirst().get();
    }

    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int ret = (nums.length * (nums.length + 1)) / 2;
        return ret-sum;
    }
}
