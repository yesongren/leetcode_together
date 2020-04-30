package src.didi.A_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC119_PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] res =  new Integer[rowIndex + 1];

        Arrays.fill(res, 0);
        res[0] = 1;

        for (int i = 1; i < rowIndex + 1; i++)
            for (int j = i; j >= 1; j--)
                res[j] += res[j - 1];

        return Arrays.asList(res);
    }

    public List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        if (rowIndex == 0) return new ArrayList<>(Arrays.asList(1));

        res.add(new ArrayList<Integer>(Arrays.asList(1)));

        if (rowIndex == 1) return new ArrayList<Integer>(Arrays.asList(1, 1));

        res.add(new ArrayList<Integer>(Arrays.asList(1, 1)));

        for (int i = 2; i < rowIndex + 1; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < res.get(i - 1).size() - 1; j++) {
                row.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            row.add(1);
            res.add(row);
        }

        return res.get(rowIndex);
    }
}
