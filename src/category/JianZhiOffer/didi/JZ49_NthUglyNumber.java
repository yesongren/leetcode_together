package src.category.JianZhiOffer.didi;

public class JZ49_NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;

        int curr2 = 2, curr3 = 3, curr5 = 5;

        for (int i = 1; i < n; i++) {
            int num = Math.min(Math.min(curr2, curr3), curr5);
            ugly[i] = num;

            if (num == curr2)
                curr2 = ugly[++index2] * 2;
            if (num == curr3)
                curr3 = ugly[++index3] * 3;
            if (num == curr5)
                curr5 = ugly[++index5] * 5;
        }

        return ugly[n - 1];
    }
}
