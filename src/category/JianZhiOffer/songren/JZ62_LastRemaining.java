package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/6/16
 * 面试题62. 圆圈中最后剩下的数字
 */
public class JZ62_LastRemaining {
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            res = (res + m) % i;
        }
        return res;
    }
}
