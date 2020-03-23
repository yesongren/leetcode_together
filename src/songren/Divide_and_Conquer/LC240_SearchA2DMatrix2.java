package songren.Divide_and_Conquer;

/**
 * Created by yesongren on 2020/3/23
 * 240. Search a 2D Matrix II
 */
public class LC240_SearchA2DMatrix2 {

    // Time: O(m+n), Space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (target < matrix[i][j]) j--;
            else if (target > matrix[i][j]) i++;
            else return true;
        }
        return false;
    }

    // Time: O(m*n), Space: O(1)
    public boolean searchMatrixBruteForce(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
