package didi.dq;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (target == matrix[row][col]) return true;

            if (target < matrix[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}