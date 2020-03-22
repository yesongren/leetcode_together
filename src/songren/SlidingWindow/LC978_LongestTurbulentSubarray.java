package songren.SlidingWindow;

/**
 * Created by yesongren on 2020/3/22
 * 978. Longest Turbulent Subarray
 */
public class LC978_LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length <= 1) {
            return 1;
        }
        int left = 0;
        int res = 1;
        for (int i = 1; i < A.length; i++) {
            int factor = diff(A[i - 1], A[i]);
            if (i == A.length - 1 || diff(A[i], A[i + 1]) * factor != -1) {
                if (factor != 0) {
                    res = Math.max(res, i - left + 1);
                }
                left = i;
            }
        }
        return res;
    }
    private int diff(int a, int b) {
        return Integer.compare(a, b);
    }
}
