package src.category.Daily_Challenge.didi;

import java.util.ArrayList;
import java.util.List;

public class Daily_Aug09 {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            dfs("", 0, 4, s, res);
            return res;
        }

        private void dfs(String ip, int i, int step, String s, List<String> res) {
            if (i == s.length() && step == 0) {
                res.add(ip.substring(0, ip.length() - 1));
                return;
            }

            if (step < 0) return;

            for (int j = i; j < i + 3; j++) {
                if (j < s.length()) {
                    if (j == i && s.charAt(j) == '0') {
                        dfs(ip + "0.", j + 1, step - 1, s, res);
                        break;
                    }
                    if (Integer.parseInt(s.substring(i, j + 1)) <= 255) {
                        dfs(ip + s.substring(i, j + 1) + '.', j + 1, step - 1, s, res);
                    }
                }
            }
        }

    }
}
