package src.didi.O_BitManipulation;

public class LC201_BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int d = Integer.MAX_VALUE; // 1s

        while ((m & d) != (n & d)) {
            d <<= 1;
        }

        return m & d;
    }
}
