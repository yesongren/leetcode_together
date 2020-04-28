package src.didi.T_SlidingWindow;

public class LC1208_GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int res = 0;
        int[] diffs = new int[n];

        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        for (int r = 0, l = 0, current = 0; r < n; r++) {
            current += diffs[r];

            while (current > maxCost) {
                current -= diffs[l];
                l++;
            }

            res = Math.max(res, r -l + 1);
        }

        return res;
    }
}
