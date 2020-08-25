package src.category.Daily_Challenge.didi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Daily_Aug25 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, -1, new ArrayList<>()); //start with -1 for duplications
        return res;
    }

    private void dfs (int[] nums, int idx, List<Integer> curr) {
        if (curr.size() > 1) res.add(new ArrayList<>(curr));

        Set<Integer> set = new HashSet<>();

        for (int i = idx + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            if (idx == -1 || nums[i] >= nums[idx]) {
                curr.add(nums[i]);
                dfs(nums, i, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
