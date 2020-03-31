package src.didi.F_HashTable;

import java.util.HashSet;
import java.util.Set;

class LC202_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            n = change(n);
            if (set.contains(n)) return false;
            set.add(n);
        }

        return true;
    }

    private int change(int n) {
        int sum = 0;
        while (n != 0) {
            int digits = n % 10;
            n /= 10;
            sum += digits * digits;
        }
        return sum;
    }
}