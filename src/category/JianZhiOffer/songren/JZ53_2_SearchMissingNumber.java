package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/22
 * 面试题53 - II. 0～n-1中缺失的数字
 */
public class JZ53_2_SearchMissingNumber {
    public int missingNumber(int[] nums) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == mid) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
