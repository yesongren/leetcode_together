package songren.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yesongren on 2020/3/31
 * 202. Happy Number
 */
public class LC202_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = changeNumber(n);
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    public int changeNumber(int n) {
        int sum = 0;
        int num;
        while (n != 0) {
            num = n % 10;
            n /= 10;
            sum += num * num;
        }
        return sum;
    }
}
