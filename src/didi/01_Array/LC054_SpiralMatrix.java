package didi.array;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

        int top = 0;
        int bot = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        int i = 0;

        while(top < bot && left < right) {
            for (i = left; i < right; i++)
                result.add(matrix[top][i]);
            top++;

            for (i = top; i < bot; i++)
                result.add(matrix[i][right - 1]);
            right--;

            if (top < bot) { // REQUIRED
                for (i = right - 1; i >= left; i--)
                    result.add(matrix[bot - 1][i]);
                bot--;
            }

            if (left < right) { // REQUIRED
                for (i = bot - 1; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }

        return result;
    }
}