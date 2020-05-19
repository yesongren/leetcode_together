package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/19
 * 面试题44. 数字序列中某一位的数字
 */
public class JZ44_FindNthDigit {
    public int findNthDigit(int m) {
        long n = m;
        long start = 1, len = 1, count = 9;

        while (n > len * count) {
            n = n - len * count;
            len++;
            count = count * 10;
            start = start * 10;
        }

        start = start + (n - 1) / len;

        return String.valueOf(start).charAt((int) ((n - 1) % len)) - '0';
    }
}
