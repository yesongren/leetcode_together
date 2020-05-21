package src.category.JianZhiOffer.didi;

public class JZ46_TranslateNum {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (translate(s.substring(i - 2, i)))
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[s.length()];
    }

    private boolean translate(String a) {
        if (a.charAt(0) == '0') return false;
        int value = Integer.parseInt(a);
        return value >= 0 && value <= 25;
    }
}
