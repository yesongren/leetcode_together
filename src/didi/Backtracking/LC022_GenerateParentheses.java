package didi.backtracking;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;

        Helper("", result, n, 0, 0);

        return result;
    }

    public void Helper(String curr, List<String> res, int n, int left, int right) {
        if (right == n) {
            res.add(curr);
            return;
        }

        if (left < n) {
            Helper(curr+"(", res, n, left + 1, right);
        }

        if (right < left) {
            Helper(curr+")", res, n, left, right + 1);
        }
    }
}