package didi.string;

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        String str = s.toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            while (left < str.length() && !isValid(str.charAt(left))) left++;
            if (left == str.length()) return true;

            while (right >= 0 && !isValid(str.charAt(right))) right--;

            if (str.charAt(left) != str.charAt(right)) return false;
            else {
                left++;
                right--;
            }
        }

        return true;
    }

    private boolean isValid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}