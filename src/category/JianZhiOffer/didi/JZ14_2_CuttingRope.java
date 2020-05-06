package src.category.JianZhiOffer.didi;

public class JZ14_2_CuttingRope {
    private int mod = 1000000007;

    public int cuttingRope(int n) {
        if(n == 2)
            return 1;
        else if(n == 3)
            return 2;
        else if(n % 3 == 0)
            return (int) (iPow(3, n / 3) % mod);
        else if(n % 3 == 1)
            return (int) ((2 * 2 * iPow(3, (n - 4) / 3)) % mod);
        else
            return (int) ((2 *  iPow(3, n / 3)) % mod);
    }

    private long iPow (int x , int n) {
        long res = 1L;

        for (int i = 0; i < n; i++) {
            res *= x;
            if (res * x > mod) res %= mod;
        }

        return res;
    }
}
