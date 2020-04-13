package songren.TwoPointers;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/4/13
 * 88. Merge Sorted Array
 */
public class LC088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
