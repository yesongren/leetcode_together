package src.didi.M_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC077_Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) return res;

        Helper(res, k, n, 1, new ArrayList<Integer>());

        return res;
    }

    private void Helper (List<List<Integer>> res, int k, int n, int start, List<Integer> curr) {
        if (k == 0) res.add(new ArrayList<Integer>(curr)); // new
        else {
            for (int i = start; i <= n; i++) {
                curr.add(i);
                Helper(res, k - 1, n, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
