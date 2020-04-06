package songren.BinarySearch;

/**
 * Created by yesongren on 2020/4/6
 * 74. Search a 2D Matrix
 */
public class LC074_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (target < matrix[i][j]) j--;
            else if (target > matrix[i][j]) i++;
            else return true;
        }
        return false;
    }
}
