package didi.string;

class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String str = "1";
        for (int i = 1; i < n; i++) {
            int count = 0;
            char prev = '.';
            StringBuilder sb = new StringBuilder();
            for (int idx = 0; idx < str.length(); idx++) {
                if (str.charAt(idx) == prev || prev == '.') count++;
                else {
                    sb.append(count + Character.toString(prev));
                    count = 1;
                }
                prev = str.charAt(idx);
            }
            sb.append(count + Character.toString(prev));
            str = sb.toString();
        }
        return str;
    }
}