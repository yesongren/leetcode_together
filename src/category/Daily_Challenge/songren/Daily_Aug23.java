package category.Daily_Challenge.songren;

/**
 * Created by yesongren on 2020/8/23
 * 201. 数字范围按位与
 */
public class Daily_Aug23 {
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            cnt++;
        }
        return m << cnt;
    }
}
