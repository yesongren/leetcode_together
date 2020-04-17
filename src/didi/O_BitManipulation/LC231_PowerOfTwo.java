package src.didi.O_BitManipulation;

public class LC231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }
}
