package src.category.JianZhiOffer.didi;

import java.util.HashSet;
import java.util.Set;

public class JZ03_FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) return i;
        }
        return -1;
    }
}
