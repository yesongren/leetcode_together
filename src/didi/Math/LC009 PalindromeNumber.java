package didi.math;

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        return x == reverse(x);
    }

    public int reverse(int num){
        int rst = 0;

        while (num != 0) {
            rst = rst * 10 + num % 10;
            num = num / 10;
        }

        return rst;
    }
}