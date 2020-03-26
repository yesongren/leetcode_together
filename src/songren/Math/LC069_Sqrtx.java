package songren.Math;

/**
 * Created by yesongren on 2020/3/26
 * 69. Sqrt(x)
 */
public class LC069_Sqrtx {

    // Time: O(log(n)), Space: O(1)
    public int sqrtBinarySearch(int n) {
        long low = 0, high = n;
        while (low <= high) {
            long mid = low + (high - low)/2;
            long mid2 = mid * mid;
            if (mid2 < n) low = mid + 1;
            else if (mid2 > n) high = mid - 1;
            else return (int)mid;
        }
        return (int)high;
    }

    // Time: O(log(n)), Space: O(1)
    public int sqrtNewton(int n) {
        long x = n;
        while (x*x > n) {
            x = (x + n/x) / 2;
        }
        return (int)x;
    }
}
