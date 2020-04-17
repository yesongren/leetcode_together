package src.didi.O_BitManipulation;

public class LC191_NumberOfOneBits {
    public int hammingWeight(int n) {
        int bit = 0;

        while(n != 0) {
            bit += (1 & n);
            n >>>= 1;
        }

        return bit;
    }
}
