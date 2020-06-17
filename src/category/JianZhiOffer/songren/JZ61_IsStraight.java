package category.JianZhiOffer.songren;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/6/16
 * 面试题61. 扑克牌中的顺子
 */
public class JZ61_IsStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int jCount = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                jCount++;
                continue;
            }
            if (nums[i] == nums[i + 1]) return false;
        }
        if (nums[4] - nums[jCount] < 5) return true;
        return false;
    }
}
