package category.JianZhiOffer.songren;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/5/8
 * 面试题29. 顺时针打印矩阵
 */
public class JZ29_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new int[]{};

        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; ++i) result.add(matrix[top][i]);
            if (++top > bottom) break;

            for (int i = top; i <= bottom; ++i) result.add(matrix[i][right]);
            if (--right < left) break;

            for (int i = right; i >= left; --i) result.add(matrix[bottom][i]);
            if (--bottom < top) break;

            for (int i = bottom; i >= top; --i) result.add(matrix[i][left]);
            if (++left > right) break;
        }

        int[] res = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
