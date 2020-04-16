package src.didi.M_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC089_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(add + res.get(j));
        }
        return res;
    }
}
