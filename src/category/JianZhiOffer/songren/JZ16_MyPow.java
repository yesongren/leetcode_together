package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/5
 * 面试题16. 数值的整数次方
 */
public class JZ16_MyPow {
    public double myPow(double x, int n) {
        int tmp_n = n;
        double ans = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n /= 2;
        }
        return tmp_n >= 0 ? ans : 1 / ans;
    }
}
