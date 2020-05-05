package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/5
 * 面试题17. 打印从1到最大的n位数
 */
public class JZ17_PrintNumbers {
    public int[] printNumbers(int n) {
        int max = QuickPow(10, n) - 1;
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
    private int QuickPow(int x, int n) {
        int ans = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n /= 2;
        }
        return ans;
    }
}
