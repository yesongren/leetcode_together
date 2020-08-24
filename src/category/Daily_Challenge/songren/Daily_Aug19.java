package category.Daily_Challenge.songren;

/**
 * Created by yesongren on 2020/8/19
 * 647. 回文子串
 */
public class Daily_Aug19 {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) return 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += expandAndCount(s, i, i);
            cnt += expandAndCount(s, i, i + 1);
        }
        return cnt;
    }
    public int expandAndCount(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
