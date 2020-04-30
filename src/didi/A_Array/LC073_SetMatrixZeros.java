package src.didi.A_Array;

public class LC073_SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !row[i]) row[i] = true;
                if (matrix[i][j] == 0 && !col[j]) col[j] = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (row[i]) {
                for (int c = 0; c < matrix[0].length; c++) {
                    if (matrix[i][c] != 0) matrix[i][c] = 0;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (col[i]) {
                for (int r = 0; r < matrix.length; r++) {
                    if (matrix[r][i] != 0) matrix[r][i] = 0;
                }
            }
        }
    }
}
