package songren.Sort;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/4/17
 * 324. Wiggle Sort II
 */
public class LC324_WiggleSort2 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, i = 0;
        int[] smaller = new int[len % 2 == 0 ? len / 2 : (len / 2 + 1)], bigger = new int[len / 2];
        System.arraycopy(nums, 0, smaller, 0, smaller.length);
        System.arraycopy(nums, smaller.length, bigger, 0, len / 2);
        for (; i < len / 2; i++) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
            nums[2 * i + 1] = bigger[len / 2 - 1 - i];
        }
        if (len % 2 != 0) nums[2 * i] = smaller[smaller.length - 1 - i];
    }
}
