package didi.math;

class Solution {
    public String convertToTitle(int n) {
        int x = n;
        StringBuilder res = new StringBuilder();

        while (x > 0) {
            x--;
            res.append((char)(x % 26 + 'A'));
            x /= 26;
        }

        return res.reverse().toString();
    }
}