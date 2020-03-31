package src.didi.F_HashTable;

public class LC204_CountPrimes {
    //埃拉托斯特尼筛法
    public int countPrimes(int n) {
        if (n <= 1) return 0;

        int res = 0;
        boolean[] notPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                res++;
                for (int j = 2; i * j < n; j++) notPrime[i * j] = true;
            }
        }

        return res;
    }
}
