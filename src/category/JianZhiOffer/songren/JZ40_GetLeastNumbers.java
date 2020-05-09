package category.JianZhiOffer.songren;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/5/9
 * 面试题40. 最小的k个数
 */
public class JZ40_GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null) return new int[] {};
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        // System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}
