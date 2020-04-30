package src.didi.A_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 0) return res;

        res.add(new ArrayList<Integer>(Arrays.asList(1)));

        if (numRows == 1) return res;

        res.add(new ArrayList<Integer>(Arrays.asList(1, 1)));

        if (numRows == 2) return res;

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < res.get(i - 1).size() - 1; j++) {
                row.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            row.add(1);
            res.add(row);
        }

        return res;
    }
}
