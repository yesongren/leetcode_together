package didi.slidingwindow;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int result = 0;
        int mostFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            mostFreq = Math.max(mostFreq, ++freq[.charAt(right) - 'A']);
            int replace = right - left + 1 - mostFreq;
            if (replace > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            } else {
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}