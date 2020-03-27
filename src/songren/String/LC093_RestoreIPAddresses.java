package songren.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/3/27
 * 93. Restore IP Addresses
 */
public class LC093_RestoreIPAddresses {
    private void backtracking(String s, int pos, List<String> cur, List<String> ans) {
        if (cur.size() >= 4) {
            if (pos == s.length()) ans.add(String.join(".", cur));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (pos + i > s.length()) break;
            String segment = s.substring(pos, pos + i);
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255))
                continue;
            cur.add(segment);
            backtracking(s, pos + i, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtracking(s, 0, new ArrayList<>(), ans);
        return ans;
    }
}
