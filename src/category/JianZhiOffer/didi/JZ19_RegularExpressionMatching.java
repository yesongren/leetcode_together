package src.category.JianZhiOffer.didi;

public class JZ19_RegularExpressionMatching {
    public boolean isMatch1(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public boolean isMatch(String s, String p) {
        // dp[i][j] = s[:,i] matches p[:,j]
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int c = 2; c < dp[0].length; c++) {
            if (p.charAt(c - 1) == '*' && dp[0][c - 2])
                dp[0][c] = true;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
