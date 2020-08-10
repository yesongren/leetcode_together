package category.Daily_Challenge.songren;

/**
 * Created by yesongren on 2020/8/10
 * 696. 计数二进制子串
 */
public class Daily_Aug10 {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int left = 0, right = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || chs[i] == chs[i - 1]) {
                left++;
            } else {
                res += Math.min(left, right);
                right = left;
                left = 1;
            }
        }
        res += Math.min(left, right);
        return res;
    }
}
