package src.category.JianZhiOffer.didi;

public class JZ17_PrintNumbers {
    public int[] printNumbers(int n) {
        int len = iPow(10, n) - 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) res[i] = i + 1;
        return res;
    }

    private int iPow(int x, int n) {
        int ans = 1;

        while (n != 0) {
            if ((n & 1) == 1) ans *= x;
            x *= x;
            n /= 2;
        }

        return ans;
    }
}
