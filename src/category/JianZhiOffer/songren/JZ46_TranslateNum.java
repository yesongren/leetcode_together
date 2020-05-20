package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/20
 * 面试题46. 把数字翻译成字符串
 */
public class JZ46_TranslateNum {
    public int translateNum(int num) {
        String s = Integer.toString(num);
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i > 1) {
                int t = (chs[i - 2] - '0') * 10 + chs[i - 1] - '0';
                if (t >= 10 && t <= 25) dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
