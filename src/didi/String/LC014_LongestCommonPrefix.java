package didi.String;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) return strs[left];
        else {
            int mid = (left + right) / 2;
            String leftLCP = longestCommonPrefix(strs, left, mid);
            String rightLCP = longestCommonPrefix(strs, mid + 1, right);
            return commonPrefix(leftLCP, rightLCP);
        }
    }

    private String commonPrefix(String left, String right) {
        int lenMin = Math.min(left.length(), right.length()); // length for String not String[]

        for (int i = 0; i < lenMin; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }else{
                continue;
            }
        }

        return left.substring(0, lenMin);
    }
}