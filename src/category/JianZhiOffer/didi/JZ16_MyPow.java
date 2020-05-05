package src.category.JianZhiOffer.didi;

public class JZ16_MyPow {
    // 奇偶 res * num
    // 正负 注意 MIN_VALUE
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        if (n == 1) return x;

        boolean isNegitive = false;

        if (n < 0) {
            isNegitive = true;
            x = 1/x;
            n = - (n + 1);
        }

        double res = 1;
        double tmp = x;

        while (n != 0) {
            if (n % 2 == 1) { // 1 % 2 = 1
                res *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }

        return isNegitive? res * x : res;
    }
}
