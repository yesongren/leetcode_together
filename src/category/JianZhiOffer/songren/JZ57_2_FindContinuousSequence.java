package category.JianZhiOffer.songren;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/5/27
 * 面试题57 - II. 和为s的连续正数序列
 */
public class JZ57_2_FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        int sum = left + right;
        List<int[]> res = new ArrayList<>();
        while(left <= target / 2 && left < right) {
            if (sum < target) {
                right++;
                sum += right;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
