package src.category.JianZhiOffer.didi;

public class JZ15_HammingWeight {
    public int hammingWeight(int n) {
        int bit = 0;

        while (n != 0) {
            bit += 1 & n;
            n >>>= 1;
        }

        return bit;
    }
}
