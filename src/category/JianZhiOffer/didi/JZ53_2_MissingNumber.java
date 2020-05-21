package src.category.JianZhiOffer.didi;

public class JZ53_2_MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
