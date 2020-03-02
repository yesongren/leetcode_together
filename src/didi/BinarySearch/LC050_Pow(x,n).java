package didi.BinarySearch;

class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = false;

        if (n < 0) {
            isNegative = true;
            x = 1 / x;
            n = - (n + 1);
        }

        double tmp = x, result = 1;

        while(n != 0) {
            if (n % 2 == 1) result *= tmp;
            tmp *= tmp; //
            n /= 2;
        }

        return isNegative ? result * x : result;
    }
}