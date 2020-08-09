package category.Daily_Challenge.songren;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/8/9
 * 93. 复原IP地址
 */
public class Daily_Aug09 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        backtrack(s, "", 0, res);
        return res;
    }

    private void backtrack(String s, String sub, int index, List<String> res) {
        // base case
        if (index == 4 || s.length() == 0) {
            if (index == 4 && s.length() == 0) res.add(sub.substring(0, sub.length() - 1));
            return;
        }
        // choose 1 digit
        backtrack(s.substring(1), sub + s.substring(0, 1) + ".", index + 1, res);
        // choose 2 digits
        if (s.length() > 1 && s.charAt(0) != '0') {
            backtrack(s.substring(2), sub + s.substring(0, 2) + ".", index + 1, res);
            // choose 3 digits
            if (s.length() > 2 && Integer.valueOf(s.substring(0, 3)) <= 255) {
                backtrack(s.substring(3), sub + s.substring(0, 3) + ".", index + 1, res);
            }
        }
    }
}
