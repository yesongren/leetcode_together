package src.didi.M_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC090_Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums); // sort first
        Helper(nums, res, 0, true, new ArrayList<Integer>());

        return res;
    }

    private void Helper(int[] nums, List<List<Integer>> res, int len, boolean taken, List<Integer> curr) {
        if (len == nums.length) res.add(new ArrayList<Integer>(curr));
        else {
            Helper(nums, res, len + 1, false, curr);
            if (taken || nums[len] != nums[len - 1]) {
                curr.add(nums[len]);
                Helper(nums, res, len + 1, true, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
