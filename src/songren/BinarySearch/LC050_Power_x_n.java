package songren.BinarySearch;

/**
 * Created by yesongren on 2020/3/3
 * 50. Pow(x, n)
 */
public class LC050_Power_x_n {
    public double divideCleanSolution(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / divideCleanSolution(x, -n);
        }
        return n % 2 == 1
                ? x * divideCleanSolution(x, n - 1)
                : divideCleanSolution(x * x, n / 2);
    }
}
