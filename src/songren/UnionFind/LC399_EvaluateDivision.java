package songren.UnionFind;

import java.util.List;

/**
 * Created by yesongren on 2020/3/21
 * 399. Evaluate Division
 */
public class LC399_EvaluateDivision {
    private List<List<String>> equations_;
    private double[] values_;
    private int[] visited;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        equations_ = equations;
        values_ = values;


        for (int i = 0; i < queries.size(); i++) {
            visited = new int[equations.size()];
            ans[i] = func(queries.get(i).get(0), queries.get(i).get(1));
            if (ans[i] < 0) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    public double func(String from, String to) {
        for (int i = 0; i < equations_.size(); i++) {
            if (visited[i] == 1) {
                continue;
            }
            List<String> equation = equations_.get(i);
            if (equation.get(0).equals(from) || equation.get(1).equals(from)) {
                if (from.equals(to)) {
                    return 1.0;
                }

                double value = values_[i];
                int entrance = 0;

                if (equation.get(1).equals(from)) {
                    value = 1 / value;
                    entrance = 1;
                }

                visited[i] = 1;
                if (equation.get(1 - entrance).equals(to)) {
                    return value;
                } else {
                    return Math.max(value * func(equation.get(1 - entrance), to), func(from, to));
                }
            }
        }
        return -1;
    }
}
