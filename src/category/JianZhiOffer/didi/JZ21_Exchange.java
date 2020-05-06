package src.category.JianZhiOffer.didi;

public class JZ21_Exchange {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 1) left++;
            else if ((nums[right] & 1) == 0) right--;
            else if ((nums[right] & 1) == 1 && (nums[left] & 1) == 0) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return nums;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
