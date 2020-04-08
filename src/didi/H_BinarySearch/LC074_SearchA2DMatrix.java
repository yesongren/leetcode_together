package src.didi.H_BinarySearch;

public class LC074_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        int colStart = 0;
        int rowStart = 0;
        int row = -1;

        while(rowStart + 1 < rowEnd) {
            int rowMid = rowStart + (rowEnd - rowStart) / 2;
            if (matrix[rowMid][colEnd] < target) rowStart = rowMid;
            else if (matrix[rowMid][colEnd] > target) rowEnd = rowMid;
            else return true;
        }

        if (matrix[rowStart][colEnd] >= target) row = rowStart;
        else if (matrix[rowEnd][colEnd] >= target) row = rowEnd;
        else return false;

        while(colStart + 1 < colEnd) {
            int colMid = colStart + (colEnd - colStart) / 2;
            if (matrix[row][colMid] < target) colStart = colMid;
            else if (matrix[row][colMid] > target) colEnd = colMid;
            else return true;
        }

        if(matrix[row][colStart] == target || matrix[row][colEnd] == target) return true;
        return false;
    }
}
