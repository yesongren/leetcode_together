package songren.Backtracking;

import java.util.*;

/**
 * Created by yesongren on 2020/3/8
 * 47. Permutations II
 */
public class LC047_Permutations2 {
    private void permuteRec(List<Integer> nums, int start, Set<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
        } else {
            for (int i = start; i < nums.size(); ++i) {
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                Collections.swap(nums, i, start);
            }
        }
    }

    // Time: O(n*n!), Space: O(n)
    public List<List<Integer>> permuteUniqueUsingHashSet(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);

        permuteRec(list, 0, result);
        return new ArrayList<>(result);
    }
}
