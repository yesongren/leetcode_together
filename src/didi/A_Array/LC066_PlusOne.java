package src.didi.A_Array;

class LC066_PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;

        int n = digits.length;
        int idx = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] res = new int[n + 1];
        res[0] = 1;

        return res;
    }
}