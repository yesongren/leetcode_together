package songren.UnionFind;

/**
 * Created by yesongren on 2020/3/21
 * 547. Friend Circles
 */
public class LC547_FriendCircles {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int cnt = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) { // '0' : have not been visited
                dfs(M, visited, i);
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
