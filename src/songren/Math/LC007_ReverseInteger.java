package songren.Math;

/**
 * Created by yesongren on 2020/2/25
 * 7. Reverse Integer
 */
public class LC007_ReverseInteger {

    public int reverse(int x) {
        long res = 0;  // cannot be 'int'
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int)res;
    }
}
