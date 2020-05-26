package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/26
 * 面试题56 - I. 数组中数字出现的次数
 */
public class JZ56_1_SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int xor = 0, mask = 1;
        for (int num : nums) xor ^= num;
        while ((xor & mask) == 0) mask <<= 1;
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & mask) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }
}
