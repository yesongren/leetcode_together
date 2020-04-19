package songren.BitManipulation;

/**
 * Created by yesongren on 2020/4/19
 * 268. Missing Number
 */
public class LC268_MissingNumber {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int sum = size * (size + 1) / 2;
        for (int num : nums) {
            sum = sum - num;
        }
        return sum;
    }
}
