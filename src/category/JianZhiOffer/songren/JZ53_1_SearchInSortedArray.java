package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/22
 * 面试题53 - I. 在排序数组中查找数字 I
 */
public class JZ53_1_SearchInSortedArray {
    public int search(int[] nums, int target) {
        int res = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] == target) {
                res++;
            }
            i++;
        }
        return res;
    }
}
