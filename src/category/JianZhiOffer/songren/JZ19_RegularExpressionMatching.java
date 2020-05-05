package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/6
 * 面试题19. 正则表达式匹配
 */
public class JZ19_RegularExpressionMatching {
    private boolean isEqual(char sc, char pc) {
        return sc == pc || pc == '.';
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[] cur = new boolean[n + 1];
        cur[0] = true;
        for (int j = 1; j <= n; ++j)
            if (p.charAt(j - 1) == '*')
                cur[j] = cur[j - 2];

        for (int i = 1; i <= m; ++i) {
            boolean pre = cur[0];
            cur[0] = false;
            for (int j = 1; j <= n; ++j) {
                boolean tmp = cur[j];
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);
                if (isEqual(sc, pc)) {
                    cur[j] = pre;
                } else if (pc == '*') {
                    char preChar = p.charAt(j - 2);
                    if (isEqual(sc, preChar)) cur[j] = cur[j - 2] || cur[j - 1] || cur[j];
                    else cur[j] = cur[j - 2];
                } else {
                    cur[j] = false;
                }
                pre = tmp;
            }
        }
        return cur[n];
    }
}
