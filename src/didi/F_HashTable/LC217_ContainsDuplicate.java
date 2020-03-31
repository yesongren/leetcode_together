package src.didi.F_HashTable;

import java.util.HashSet;
import java.util.Set;

public class LC217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) if (!set.add(num)) return true;
        return false;
    }
}
