package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/5
 * 面试题14- II. 剪绳子 II
 */
public class JZ14_2_CuttingRope {

    public int cuttingRope(int n) {
        if (n < 2) return 2;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int p3 = n / 3;
        if (n - 3 * p3 == 1) {
            p3 -= 1;
        }
        int p2 = (n - p3 * 3) / 2;
        int mod = 1000000007;
        return (int) ((quickPowMod(3, p3, mod) * quickPowMod(2, p2, mod)) % mod);
    }

    private long quickPowMod(long a, long b, int m) {
        long ans = 1;
        a = a % m;
        while (b != 0) {
            if ((b & 1) > 0) ans = ((ans % m) * a) % m;
            b >>= 1;
            a = (a * a) % m;
        }
        return ans;
    }
}
