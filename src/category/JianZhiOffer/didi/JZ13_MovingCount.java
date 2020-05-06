package src.category.JianZhiOffer.didi;

public class JZ13_MovingCount {
    private int count = 0;

    public int movingCount(int row, int col, int k) {
        boolean[][] visited = new boolean[row][col];
        helper(visited, 0, 0, row, col, k);
        return count;
    }

    private void helper(boolean[][] visited, int r, int c, int row, int col, int k) {
        boolean bound = r < row && c < col && !visited[r][c] && (digitSum(r) + digitSum(c) <= k);
        if (bound) {
            count++;
            visited[r][c] = true;
            helper(visited, r + 1, c, row, col, k);
            helper(visited, r, c + 1, row, col, k);
        }
    }

    private int digitSum(int a) {
        int sum = 0;

        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }

        return sum;
    }
}
