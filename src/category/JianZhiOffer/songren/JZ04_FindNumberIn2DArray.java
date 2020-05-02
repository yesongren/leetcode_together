package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/5/2
 * 面试题04. 二维数组中的查找
 */
public class JZ04_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (target < matrix[i][j]) j--;
            else if (target > matrix[i][j]) i++;
            else return true;
        }
        return false;
    }
}
