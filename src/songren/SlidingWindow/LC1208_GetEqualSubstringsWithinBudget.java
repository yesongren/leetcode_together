package songren.SlidingWindow;

/**
 * Created by yesongren on 2020/4/25
 * 1208. Get Equal Substrings Within Budget
 */
public class LC1208_GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int temp = 0;
        int l = 0;
        int r = 0;
        int ans = 0;
        while (l < n && r < n) {
            temp += Math.abs(s.charAt(r) - t.charAt(r));
            if (temp <= maxCost) {
                r++;
                ans = Math.max(ans, r - l);
            } else {
                while (temp > maxCost) {
                    temp = temp - Math.abs(s.charAt(l) - t.charAt(l));
                    l++;
                }
                r++;
            }
        }
        return ans;
    }
}
