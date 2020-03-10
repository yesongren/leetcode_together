package songren.BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/3/10
 * 78. Subsets
 */
public class LC078_Subsets {
    private void subsets(int[] nums, int start, List<Integer> elem, List<List<Integer>> result) {
        result.add(new ArrayList<>(elem));
        for (int i = start; i < nums.length; ++i) {
            elem.add(nums[i]);
            subsets(nums, i + 1, elem, result);
            elem.remove(elem.size() - 1);
        }
    }

    // Time: O(2^n), Space: O(n)
    public List<List<Integer>> subsetsRecursive(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        subsets(nums, 0, elem, result);
        return result;
    }

    // Time: O(n*2^n), Space: O(1)
    public List<List<Integer>> subsetsBit(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int N = (int)Math.pow(2, n);

        for (int i = 0; i < N; ++i) {
            List<Integer> elem = new ArrayList<>();
            for (int j = 0; j < n; ++j)
                if (((i >> j) & 1) == 1)
                    elem.add(nums[j]);
            result.add(elem);
        }
        return result;
    }
}
