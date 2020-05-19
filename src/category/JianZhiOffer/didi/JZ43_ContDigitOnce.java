package src.category.JianZhiOffer.didi;

public class JZ43_ContDigitOnce {
    int[] arr;
    public int countDigitOne(int n) {
        this.arr = new int[11];
        arr[0] = 0;
        int temp = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = 10 * arr[i - 1] + temp;
            temp *= 10;
        }
        return f(n);
    }
    private int f(int n) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length()-1);
        int last = n - high*pow;
        if (high == 1) {
            int res = arr[s.length()-1] + last + 1 + f(last);
            return res;
        } else {
            int res = pow + high*arr[s.length()-1] + f(last);
            return res;
        }
    }
}
