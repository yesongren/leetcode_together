package src.category.JianZhiOffer.didi;

public class JZ29_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int top = 0;
        int bot = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        int[] result = new int[bot * right];
        int i;
        int x = 0;

        while(top < bot && left < right) {
            for (i = left; i < right; i++)
                result[x++] = matrix[top][i];
            top++;

            for (i = top; i < bot; i++)
                result[x++] = matrix[i][right - 1];
            right--;

            if (top < bot) { // REQUIRED
                for (i = right - 1; i >= left; i--)
                    result[x++] = matrix[bot - 1][i];
                bot--;
            }

            if (left < right) { // REQUIRED
                for (i = bot - 1; i >= top; i--)
                    result[x++] = matrix[i][left];
                left++;
            }
        }

        return result;
    }
}
