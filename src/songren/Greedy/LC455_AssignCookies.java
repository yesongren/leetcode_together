package songren.Greedy;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/4/9
 * 455. Assign Cookies
 */
public class LC455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) child++;
            cookie++;
        }
        return child;
    }
}
