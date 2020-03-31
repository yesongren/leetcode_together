package didi.dp;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int left = 0, right = 0, len = 0;

        for (int i = 0; i < s.length(); i++){
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            len = Math.max(len1, len2);
            if (len > right - left ){
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }

        return s.substring(left, right + 1);
    }

    public int expandFromMiddle (String s, int left, int right){
        if (s == null || left > right) return 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; // expand
            right++;
        }

        return right - left - 1;
    }
}