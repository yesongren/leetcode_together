package didi.heap;

class Solution {
    // 16 ms
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes == null || primes.length == 0) return 0;

        int[] times = new int[primes.length];
        int[] uglys = new int[n];
        uglys[0] = 1;

        for (int i = 1; i < n; i++) {
            uglys[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                uglys[i] = Math.min(uglys[i], primes[j] * uglys[times[j]]);
            }

            for (int j = 0; j < times.length; j++) {
                if (uglys[times[j]] * primes[j] == uglys[i]) {
                    times[j]++;
                }
            }
        }

        return uglys[n - 1];
    }

    // 591 ms
    public int nthSuperUglyNumber1(int n, int[] prime) {
        Queue<Long> Q = new PriorityQueue<Long>();
        HashSet<Long> inQ = new HashSet<Long>();

        long[] primes = Arrays.stream(prime).asLongStream().toArray();

        for (int i = 0; i < primes.length; i++) {
            Q.add(primes[i]);
            inQ.add(primes[i]);
        }

        Long number = Long.valueOf(1);

        for (int i = 1; i < n; i++) {
            number = Q.poll();
            for (int j = 0; j < primes.length; j++) {
                if (!inQ.contains(primes[j] * number)) {
                    Q.add(number * primes[j]);
                    inQ.add(number * primes[j]);
                }
            }
        }

        return number.intValue();
    }
}