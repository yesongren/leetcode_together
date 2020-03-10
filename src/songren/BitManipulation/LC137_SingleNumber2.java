package songren.BitManipulation;

/**
 * Created by yesongren on 2020/3/11
 * 137. Single Number II
 */
public class LC137_SingleNumber2 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1;
            bit <<= i;
            int count = 0;
            for (int num : nums) {
                if ((bit & num) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                result |= bit;
            }
        }
        return result;
    }
}
