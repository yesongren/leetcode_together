package didi.BinarySearch;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean isNegative = false;

        if (dividend < 0 && divisor > 0 || divisor < 0 && dividend > 0) isNegative = true;

        long numerator = Math.abs((long) dividend);
        long denomenator = Math.abs((long) divisor);

        int result = 0;
        long tmp = numerator;

        while(tmp >= denomenator) {
            int shift = 0; //
            while (tmp >= denomenator << shift) shift++;
            result += 1 << shift - 1; //
            tmp -= denomenator << shift - 1; //
        }

        return isNegative ? -result : result;
    }
}