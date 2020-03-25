package didi.array;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0;
        int bot = n;
        int left = 0;
        int right = n;
        int i = 0;
        int curr = 1;

        while(top < bot && left < right) {
            for (i = left; i < right; i++){
                matrix[top][i] = curr;
                curr++;
            }
            top++;

            for (i = top; i < bot; i++) {
                matrix[i][right - 1] = curr;
                curr++;
            }
            right--;

            if (top < bot) { // REQUIRED
                for (i = right - 1; i >= left; i--) {
                    matrix[bot - 1][i] = curr;
                    curr++;
                }
                bot--;
            }

            if (left < right) { // REQUIRED
                for (i = bot - 1; i >= top; i--) {
                    matrix[i][left] = curr;
                    curr++;
                }
                left++;
            }
        }

        return matrix;
    }
}