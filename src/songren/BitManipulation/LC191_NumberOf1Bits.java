package songren.BitManipulation;

/**
 * Created by yesongren on 2020/4/19
 * 191. Number of 1 Bits
 */
public class LC191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            count += (n >> (31 - i) & 1) == 1 ? 1 : 0;
        }
        return count;
    }
}
