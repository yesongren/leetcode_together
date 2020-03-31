package didi.twopointers;

class Solution {
    // 2 ms
    public int strStr1(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int len = needle.length();

        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0))
                if (i + len <= haystack.length())
                    if (haystack.substring(i,i+len).equals(needle))
                        return i;
        }

        return -1;
    }
    // 0 ms (change for condition)
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int len = needle.length();

        for (int i = 0; i <= haystack.length() - len; i++) {
            if(haystack.charAt(i) == needle.charAt(0))
                if (haystack.substring(i,i+len).equals(needle))
                    return i;
        }

        return -1;
    }
}