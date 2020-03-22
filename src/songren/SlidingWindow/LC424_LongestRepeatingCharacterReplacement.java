package songren.SlidingWindow;

/**
 * Created by yesongren on 2020/3/22
 * 424. Longest Repeating Character Replacement
 */
public class LC424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int left = 0;
        int right = 0;

        int[] counts = new int[26];
        int maxCounts = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            int index = c - 'A';
            counts[index]++;
            maxCounts = Math.max(maxCounts, counts[index]);
            while (right - left + 1 - maxCounts > k) {
                c = s.charAt(left);
                counts[c - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);

            right++;
        }
        return ans;
    }
}
