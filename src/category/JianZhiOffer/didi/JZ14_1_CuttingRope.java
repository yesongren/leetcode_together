package src.category.JianZhiOffer.didi;

import java.util.HashMap;

public class JZ14_1_CuttingRope {
    HashMap<Integer,Integer> map = new HashMap<>();

    public int cuttingRope(int n) {
        if(n == 1) return 1;

        if(map.containsKey(n)) return map.get(n);

        int res = -1;
        for (int i = 1; i <= n / 2; i++) {
            res = Math.max(res, Math.max(i, cuttingRope(i)) * Math.max(n - i, cuttingRope(n - i)));
        }
        map.put(n, res);

        return res;
    }

    public int cuttingRope1(int n) {
        if (n <= 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }

        return dp[n];
    }
}
