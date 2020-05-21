package src.category.JianZhiOffer.didi;

import java.util.HashMap;

public class JZ48_LengestSubstring {
    public int lengthOfLongestSubstring0(String s) {
        if (s.length() == 0) return 0;
        int max = 0;

        HashMap<Character,Integer> check = new HashMap<>();

        int left = 0, right = 0;

        while (right < s.length()) {
            if (check.containsKey(s.charAt(right))){
                left = Math.max(check.get(s.charAt(right)), left);
            }
            max = Math.max(max, right - left + 1);
            check.put(s.charAt(right), right + 1);
            right++;
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[128];
        int maxLen = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            counts[c]++;
            if (counts[c] <= 1) {
                int len = r - l + 1;
                if (len > maxLen) {
                    maxLen = len;
                }
            }

            while(counts[c] > 1) {
                counts[s.charAt(l)]--;
                l++;
            }
        }
        return maxLen;
    }
}
