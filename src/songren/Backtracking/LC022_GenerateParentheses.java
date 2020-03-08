package songren.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/3/8
 * 22. Generate Parentheses
 */
public class LC022_GenerateParentheses {
    /**
     * 1. 任何时候写下左括号都是合法的
     * 2. 已经写下的左括号比右括号多时,写下右括号才是合法的
     */
    private void generate(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
        } else {
            if (left > 0) generate(result, str + '(', left - 1, right);
            if (right > left) generate(result, str + ')', left, right - 1);
        }
    }

    // Time: O(4^n / sqrt(n)), Space: O(n)
    public List<String> generateParentheses(int n) {
        if (n <= 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }


    // Time: O(4^n / n*sqrt(n)), Space: O(4^n / n*sqrt(n))
    public List<String> generateParenthesesDP(int n) {
        if (n <= 0) return new ArrayList<>();
        List<List<String>> d = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; ++i) d.add(new ArrayList<String>());
        d.get(0).add("");
        for (int i = 1; i < n + 1; ++i)
            for (int j = 0; j < i; ++j)
                for (String left : d.get(j))
                    for (String right : d.get(i - j - 1))
                        d.get(i).add('(' + left + ')' + right);

        return d.get(n);
    }
}
