package songren.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yesongren on 2020/3/25
 * 139. Word Break
 */
public class LC139_WordBreak {
    // Time: O(n^2), Space: O(n+m)
    public boolean stringBreak(String s, List<String> list) {
        int n = s.length();
        boolean[] d = new boolean[n+1];
        d[0] = true;
        Set<String> set = new HashSet<>(list);
        for (int i = 1; i <= n; ++i) {
            for (int j = i-1; j >= 0; --j) {
                if (d[j] && set.contains(s.substring(j, i))) {
                    d[i] = true;
                    break;
                }
            }
        }
        return d[n];
    }
}
