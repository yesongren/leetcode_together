package didi.array;

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int n = matrix.length;

        for (int row = 0; row < n / 2; row++) {
            for (int col = 0; col < n; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n - row - 1][col];
                matrix[n - row - 1][col] = tmp;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }
}