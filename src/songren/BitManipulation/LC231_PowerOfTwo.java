package songren.BitManipulation;

/**
 * Created by yesongren on 2020/4/19
 * 231. Power of Two
 */
public class LC231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 0)
            return false;
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                count++;
            n >>>= 1;
            if (count > 1) return false;
        }
        return count == 1;
    }
}
