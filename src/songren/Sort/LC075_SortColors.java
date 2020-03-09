package songren.Sort;

/**
 * Created by yesongren on 2020/3/9
 * 75. Sort Colors
 */
public class LC075_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == 0) ++cnt0;
            else if (num == 1) ++cnt1;
            else ++cnt2;
        }
        int k = 0;
        for (int i = 0; i < cnt0; ++i) nums[k++] = 0;
        for (int i = 0; i < cnt1; ++i) nums[k++] = 1;
        for (int i = 0; i < cnt2; ++i) nums[k++] = 2;
    }
}
