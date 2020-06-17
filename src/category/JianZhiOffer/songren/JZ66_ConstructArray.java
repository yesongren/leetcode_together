package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/6/17
 * 面试题66. 构建乘积数组
 */
public class JZ66_ConstructArray {
    public int[] constructArr(int[] a) {
        if (a == null || a.length < 1) return new int[]{};
        int[] res = new int[a.length];
        int left = 1, right = 1;
        for (int i = 0; i < a.length; ++i) {
            res[i] = left;
            left *= a[i];
        }
        for (int i = a.length - 1; i >= 0; --i) {
            res[i] *= right;
            right *= a[i];
        }
        return res;
    }
}
