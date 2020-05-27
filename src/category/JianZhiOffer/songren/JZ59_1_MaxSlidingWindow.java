package category.JianZhiOffer.songren;

import java.util.TreeMap;

/**
 * Created by yesongren on 2020/5/27
 * 面试题59 - I. 滑动窗口的最大值
 */
public class JZ59_1_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length, p = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; ++i) map.put(nums[i], i);
        int[] result = new int[n - k + 1];
        result[p++] = map.lastKey();
        for (int i = k; i < n; ++i) {
            if (map.get(nums[i - k]) == i - k) map.remove(nums[i - k]);
            map.put(nums[i], i);
            result[p++] = map.lastKey();
        }
        return result;
    }
}
