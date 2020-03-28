package didi.string;

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (count == 0) {
                if (s.charAt(i) == ' ') continue;
                else count = 1;
            } else {
                if (s.charAt(i) == ' ') break;
                else count++;
            }
        }

        return count;
    }
}