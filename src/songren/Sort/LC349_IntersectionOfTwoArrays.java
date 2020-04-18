package songren.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yesongren on 2020/4/17
 * 349. Intersection of Two Arrays
 */
public class LC349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pre = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                if (pre != nums1[i]) {
                    pre = nums1[i];
                    temp.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = temp.get(i);
        return res;
    }
}
