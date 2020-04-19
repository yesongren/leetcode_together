package songren.BitManipulation;

/**
 * Created by yesongren on 2020/4/19
 * 201. Bitwise AND of Numbers Range
 */
public class LC201_BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        while (m < n) {
            n &= n - 1;
        }
        return n;
    }
}
