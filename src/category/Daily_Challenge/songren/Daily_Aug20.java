package category.Daily_Challenge.songren;

/**
 * Created by yesongren on 2020/8/20
 * 529. 扫雷游戏
 */
public class Daily_Aug20 {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        board[x][y] = 'B';
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'M')
                cnt++;
        }
        if (cnt != 0) {
            board[x][y] = (char) (cnt + '0');
            return board;
        }
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length
                    && board[newX][newY] == 'E')
                updateBoard(board, new int[]{newX, newY});
        }
        return board;
    }
}
