package category.JianZhiOffer.songren;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/5/10
 * 面试题45. 把数组排成最小的数
 */
public class JZ45_MinNumber {
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] strNum = new String[len];
        for (int i = 0; i < len; i++) {
            strNum[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNum, (a, b) -> {
            if ((a + b).compareTo(b + a) < 0)
                return -1;
            return 1;
        });
        StringBuilder ans = new StringBuilder();
        for (String str : strNum)
            ans.append(str);
        return ans.toString();
    }
}
