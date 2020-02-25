package didi.math;

class Solution {
    public int reverse(int x) {
        String xString = Integer.toString(x);
        int idx = (x > 0)? 0 : 1;
        int sum = 0;
        int len = xString.length()-idx;
        int power = 0;

        for (int i = idx; i < xString.length(); i++){
            if (power > len) break;
            char c = xString.charAt(i);
            sum += Character.getNumericValue(c) * Math.pow(10,power);
            power++;
        }

        if (sum > Integer.MAX_VALUE - 1 || sum < Integer.MIN_VALUE) sum = 0;

        if (idx == 1) sum = -sum;

        return sum;
    }
}