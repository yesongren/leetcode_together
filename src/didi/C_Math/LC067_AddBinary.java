package didi.math;

class Solution {
    public String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();

        String res = "";
        int carry = 0;

        for (int i = l1 - 1, j = l2 - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            res = (sum % 2) + res;
            carry = sum / 2;
        }

        res = (carry != 0) ?  carry + res : res;

        return res;
    }
}