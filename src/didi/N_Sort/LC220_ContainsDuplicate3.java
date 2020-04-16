package src.didi.N_Sort;

import java.util.TreeSet;

public class LC220_ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || t < 0 || k < 0 || nums.length == 0) return false;

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer low = treeSet.floor(nums[i]);
            Integer high = treeSet.ceiling(nums[i]);

            if ((low != null && (long) nums[i] - low <= t) || (high != null && (long) high - nums[i] <= t))
                return true;

            treeSet.add(nums[i]);

            if (i >= k)
                treeSet.remove(nums[i - k]);
        }

        return false;
    }
}
