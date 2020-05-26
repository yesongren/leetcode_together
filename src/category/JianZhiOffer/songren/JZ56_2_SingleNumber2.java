package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/26
 * 面试题56 - II. 数组中数字出现的次数 II
 */
public class JZ56_2_SingleNumber2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int bit = 0; bit < 32; ++bit) {
            int ones = 0;
            for (int num : nums) {
                ones += (num >> bit) & 1;
            }
            if (ones % 3 == 1) res |= (1 << bit);
        }
        return res;
    }
}
