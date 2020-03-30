package songren.HashTable;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/3/31
 * 204. Count Primes
 */
public class LC204_CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        int upper = (int) Math.sqrt(n);
        for (int i = 2; i <= upper; ++i) {
            if (primes[i])
                for (int j = i * i; j < n; j += i) primes[j] = false;
        }
        int cnt = 0;
        for (boolean prime : primes)
            if (prime) ++cnt;
        return cnt;
    }
}
