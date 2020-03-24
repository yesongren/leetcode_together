package songren.Array;

/**
 * Created by yesongren on 2020/3/24
 * 66. Plus One
 */
public class LC066_PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) return new int[]{-1, -1};
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
