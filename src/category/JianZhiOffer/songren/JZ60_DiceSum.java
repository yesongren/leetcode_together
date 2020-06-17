package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/6/16
 * 面试题60. n个骰子的点数
 */
public class JZ60_DiceSum {
    public double[] twoSum(int n) {
        //dp[i][j]代表前i枚骰子和为j的概率
        double[][] dp = new double[n + 1][6 * n + 1];
        double probability = 1.0 / 6.0;
        // init
        for (int i = 1; i <= 6; i++) dp[1][i] = probability;
        //枚举骰子
        for (int i = 2; i <= n; i++) {
            //枚举点数
            for (int j = i; j <= i * 6; j++) {
                //枚举当前骰子的点数
                for (int k = 1; k < j && k <= 6; k++) {
                    dp[i][j] += (probability * dp[i - 1][j - k]);
                }
            }
        }
        double[] res = new double[5 * n + 1];
        System.arraycopy(dp[n], n, res, 0, res.length);
        return res;
    }
}
