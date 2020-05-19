package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/19
 * 面试题43. 1～n整数中1出现的次数
 */
public class JZ43_CountDigitOne {
    // Time: O(n*log10(n)), Space: O(1)
    public int countDigitOneBruteForce(int n) {
        if (n < 1) return 0;
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            int num = i;
            while (num != 0) {
                if (num % 10 == 1) ++count;
                num = num / 10;
            }
        }
        return count;
    }

    // Time: O(log10(n)), Space: O(1)
    public int countDigitOneMath(int n) {
        if (n < 1) return 0;
        long count = 0, factor = 1;
        while (n / factor != 0) {
            long digit = (n / factor) % 10;
            long high = n / (10 * factor);
            if (digit == 0) {
                count += high * factor;
            } else if (digit == 1) {
                count += high * factor;
                count += (n % factor) + 1;
            } else {
                count += (high + 1) * factor;
            }
            factor = factor * 10;
        }
        return (int) count;
    }
}
