package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/22
 * 面试题51. 数组中的逆序对
 */
public class JZ51_ReversePairs {

    // TLE, Time: O(n^2), Space: O(1)
    public int reversePairsBruteForce(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) cnt++;
            }
        }
        return cnt;
    }

    // AC, Time: O(n*log(n)), Space: O(n)
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int[] tmp = new int[nums.length];
        return sortAndCount(nums, 0, nums.length - 1, tmp);

    }

    private int mergeAndCount(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = low, j = mid + 1, k = 0, cnt = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                cnt += mid - i + 1;
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= mid) tmp[k++] = arr[j++];
        System.arraycopy(tmp, 0, arr, low, k);
        return cnt;
    }

    private int sortAndCount(int[] arr, int low, int high, int[] tmp) {
        int cnt = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            cnt += sortAndCount(arr, low, mid, tmp);
            cnt += sortAndCount(arr, mid + 1, high, tmp);
            cnt += mergeAndCount(arr, low, mid, high, tmp);
        }
        return cnt;
    }
}
