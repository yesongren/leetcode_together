package category.JianZhiOffer.songren;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yesongren on 2020/5/2
 * 面试题03. 数组中重复的数字
 */
public class JZ03_FindRepeatNumber {

    // HashSet
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return num;
        }
        return -1;
    }


    // Use Array instead of HashSet
    public int findRepeatNumber2(int[] nums) {
        int[] cnt = new int[nums.length];
        for (int index : nums) {
            if (cnt[index] == 1) return index;
            cnt[index] = 1;
        }
        return -1;
    }
}
