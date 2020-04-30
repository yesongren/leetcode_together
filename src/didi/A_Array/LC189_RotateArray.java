package src.didi.A_Array;

public class LC189_RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    public void reverse(int[] n, int i, int j) {
        for (int p = i, q = j; p < q; p++, q--) {
            int temp = n[p];
            n[p] = n[q];
            n[q] = temp;
        }
    }
}
