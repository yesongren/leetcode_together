package src.didi.K_TwoPointers;

public class LC088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, len = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) nums1[len--] = nums1[i--];
            else nums1[len--] = nums2[j--];
        }

        while (j >= 0) {
            nums1[len--] = nums2[j--];
        }
    }
}
