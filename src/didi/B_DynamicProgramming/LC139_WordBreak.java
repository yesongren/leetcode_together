package src.didi.B_DynamicProgramming;

import java.util.HashSet;
import java.util.List;

class LC139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> dict = new HashSet<>(wordDict);
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = i; j >= 1; j--) {
                if (dp[i - j] && dict.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}