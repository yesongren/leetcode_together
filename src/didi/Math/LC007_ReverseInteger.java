package didi.math;

class Solution {
    public int reverse1(int x) {
        String xString = Integer.toString(x);
        int idx = (x > 0)? 0 : 1;
        int sum = 0;
        int len = xString.length()-idx;
        int power = 0;

        for (int i = idx; i < xString.length(); i++){
            if (power > len) break;
            char c = xString.charAt(i);
            sum += Character.getNumericValue(c) * Math.pow(10,power);
            if (sum > Integer.MAX_VALUE - 1 || sum < Integer.MIN_VALUE) return 0;
            power++;
        }

        if (idx == 1) sum = -sum;

        return sum;
    }

    public int reverse(int x){
        int sign = (x > 0)? 1 : -1;
        x = Math.abs(x);
        int res = 0;

        while(x > 0){
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) return 0;
            int pop = x % 10;
            x /= 10;
            res = res * 10 + pop;
        }

        return sign * res;
    }
}