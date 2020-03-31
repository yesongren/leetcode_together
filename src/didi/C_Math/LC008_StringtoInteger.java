package didi.math;

class Solution {
    public int myAtoi(String str) {
        int idx = 0;

        if (str.length() < 1) return 0;

        while (idx < str.length() && str.charAt(idx) == ' ') { // '' not ""
            idx++;
        }

        if (idx >= str.length()) return 0;

        int sign = 1;

        if (str.charAt(idx) == '-' || str.charAt(idx) == '+'){ // case: "-+1"
            sign = (str.charAt(idx) == '-')? -1 : 1;
            idx++;
        }

        if (idx >= str.length()) return 0;

        int sum = 0;

        for (int i = idx; i < str.length(); i++){
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) break;
            if (sum > (Integer.MAX_VALUE - 1) / 10 || (Integer.MAX_VALUE / 10 == sum && Integer.MAX_VALUE % 10 < digit))
                return (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
            sum = 10 * sum + digit;
        }

        return sign * sum;
    }
}