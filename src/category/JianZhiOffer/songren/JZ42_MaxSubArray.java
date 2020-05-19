package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/19
 * 面试题42. 连续子数组的最大和
 */
public class JZ42_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(local + nums[i], nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }
}
