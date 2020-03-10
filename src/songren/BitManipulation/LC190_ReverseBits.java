package songren.BitManipulation;

/**
 * Created by yesongren on 2020/3/11
 * 190. Reverse Bits
 */
public class LC190_ReverseBits {

    // Time: O(1), Space: O(1)
    public int reverseBitsOneByOne(int n) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        return result;
    }
}
