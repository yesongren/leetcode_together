package didi.greedy;

class Solution {
    public boolean isSubsequence(String s, String t) {
        // if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int j = 0; // long

        for (int i = 0; i < sArray.length; i++){
            while(j < tArray.length && tArray[j] != sArray[i]) {
                j++;
            }
            if (j == tArray.length) return false;
            j++;

        }
        return true;
    }
}