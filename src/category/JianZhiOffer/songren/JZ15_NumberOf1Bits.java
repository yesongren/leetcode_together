package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/5
 * 面试题15. 二进制中1的个数
 */
public class JZ15_NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            count += (n >> (31 - i) & 1) == 1 ? 1 : 0;
        }
        return count;
    }
}
