package songren.Sort;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/4/17
 * 274. H-Index
 */
public class LC274_HIndex {
    private int[] arr;
    private int ans;

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        arr = citations;

        binary(0, citations.length - 1);

        return ans;
    }

    private void binary(int start, int end) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;

        int h = arr.length - mid;

        if (h <= arr[mid]) {
            ans = h;
            binary(start, mid - 1);
        } else {
            binary(mid + 1, end);
        }
    }
}
