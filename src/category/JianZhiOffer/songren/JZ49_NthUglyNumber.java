package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/20
 * 面试题49. 丑数
 */
public class JZ49_NthUglyNumber {
    public int nthUglyNumber(int n) {
        // Write your code here
        int[] u = new int[n];
        u[0] = 1;
        int u2 = 0, u3 = 0, u5 = 0;
        for (int i = 1; i < n; i++) {
            u[i] = min(min(u[u2] * 2, u[u3] * 3), u[u5] * 5);
            if ((u[i] / u[u2]) == 2) u2++;
            if ((u[i] / u[u3]) == 3) u3++;
            if ((u[i] / u[u5]) == 5) u5++;
        }
        return u[n - 1];
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }
}
