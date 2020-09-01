package category.Daily_Challenge.songren;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yesongren on 2020/8/25
 * 491. 递增子序列
 */
public class Daily_Aug25 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        findSub(set, nums, new ArrayList<>(), 0);
        return new ArrayList<>(set);
    }

    public void findSub(Set<List<Integer>> set, int[] nums, List<Integer> tmp, int index) {
        if (tmp.size() > 1) set.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            if (tmp.size() == 0 || tmp.get(tmp.size() - 1) <= nums[i]) {
                tmp.add(nums[i]);
                findSub(set, nums, tmp, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
