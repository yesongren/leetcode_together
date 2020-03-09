package songren.Sort;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/3/9
 * 56. Merge Intervals
 */
public class LC056_MergeIntervals {
    public String largestNumberFast(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> {
            int n1 = o1.length(), n2 = o2.length();
            for (int i = 0; i < n1 + n2; ++i) {
                char c1 = i < n1 ? o1.charAt(i) : o2.charAt(i - n1);
                char c2 = i < n2 ? o2.charAt(i) : o1.charAt(i - n2);
                if (c1 == c2) continue;
                return c2 - c1;
            }
            return 0;
        });
        if (strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str : strs) sb.append(str);
        return sb.toString();
    }
}
