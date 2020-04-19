package src.didi.P_Graph;

import java.util.Arrays;

public class LC743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] G = new int[N+1][N+1];

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                G[i][j] = Integer.MAX_VALUE;

        for (int[] time : times) G[time[0]][time[1]] = time[2];

        int[] dis = new int[N + 1];
        boolean[] vis = new boolean[N + 1];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K] = 0;

        for(int i = 1; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            int minNode = K;

            for(int j = 1; j <= N; j++) {
                if(!vis[j] && dis[j] < min){
                    min = dis[j];
                    minNode = j;
                }
            }

            vis[minNode] = true;

            for(int j = 1; j <= N; j++)
                if(G[minNode][j] != Integer.MAX_VALUE && !vis[j] && dis[minNode] != Integer.MAX_VALUE && dis[j] > dis[minNode] + G[minNode][j])
                    dis[j] = dis[minNode] + G[minNode][j];
        }

        int ans = 0;

        for(int i = 1; i <= N; i++)
            ans = Math.max(ans, dis[i]);

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
