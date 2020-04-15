package songren.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yesongren on 2020/4/15
 * 77. Combinations
 */
public class LC077_Combinations {
    private void combine(int n, int k, int start, List<Integer> elem, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(elem));
        } else {
            for (int i = start; i <= n - k + 1; ++i) {
                elem.add(i);
                combine(n, k - 1, i + 1, elem, result);
                elem.remove(elem.size() - 1);
            }
        }
    }

    // Time: O(k*C(n, k)), Space: O(k)
    public List<List<Integer>> combineRecursive(int n, int k) {
        if (k > n) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        combine(n, k, 1, elem, result);
        return result;
    }

    // Time: O(k*C(n, k)), Space: O(k*C(n, k))
    public List<List<Integer>> combineIterative(int n, int k) {
        if (k > n) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n - k + 1; ++i) result.add(Collections.singletonList(i));
        for (int i = 2; i <= k; ++i) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> elem : result) {
                int lastNum = elem.get(elem.size() - 1);
                for (int j = lastNum + 1; j <= n - k + i; ++j) {
                    List<Integer> copy = new ArrayList<>(elem);
                    copy.add(j);
                    tmp.add(copy);
                }
            }
            result = tmp;
        }
        return result;
    }
}
