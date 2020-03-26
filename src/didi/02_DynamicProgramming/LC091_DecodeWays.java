package didi.dp;

class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1) return num(s,0,1);

        int[] dp = new int[s.length()];

        if (s.charAt(0) == '0') return 0;

        dp[0] = 1;

        if (num(s,1,2) == 1 && num(s,0,2) == 1) dp[1] = 2;
        else if (num(s,1,2) == 1) dp[1] = 1;
        else if (num(s,0,2) == 1) dp[1] = 1;
        else return 0;

        for (int i = 2; i < s.length(); i++) {
            if (num(s,i,i+1) == 1 && num(s,i-1,i+1) == 1) {
                if (s.charAt(i - 1) == '0') dp[i] = dp[i - 1];
                else dp[i] = dp[i - 1] + dp[i - 2];
            }
            else if (num(s,i,i+1) == 1 ) dp[i] = dp[i - 1];
            else if (num(s,i-1,i+1) == 1) dp[i] = dp[i - 2];
            else return 0;
        }

        return dp[s.length() - 1];
    }

    private int num(String s, int start, int end) {
        int x = Integer.parseInt(s.substring(start,end));
        if (x > 0 && x < 27) return 1;
        else return 0;
    }
}