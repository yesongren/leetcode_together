package songren.BitManipulation;

/**
 * Created by yesongren on 2020/4/19
 * 260. Single Number III
 */
public class LC260_SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        int xorRes = 0;
        for (int x : nums) {
            xorRes ^= x;
        }
        int temp = 1;
        while ((xorRes & 1) != 1) {
            temp = temp << 1;
            xorRes = xorRes >> 1;
        }

        for (int y : nums) {
            if ((y & temp) == 0) {
                res[0] ^= y;
            } else {
                res[1] ^= y;
            }
        }
        return res;
    }
}
