package songren.SlidingWindow;

/**
 * Created by yesongren on 2020/4/25
 * 1052. Grumpy Bookstore Owner
 */
public class LC1052_GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0)
                sum += customers[i];
        }
        for (int j = 0; j < X; j++) {
            if (grumpy[j] == 1)
                temp += customers[j];
        }
        int max = temp;
        for (int i = 1; i <= (customers.length - X); i++) {
            if (grumpy[i - 1] == 1) {
                temp -= customers[i - 1];
            }
            if (grumpy[i + X - 1] == 1) {
                temp += customers[i + X - 1];
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max + sum;
    }
}
