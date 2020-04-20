package songren.Graph;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/4/20
 * 743. Network Delay Time
 */
public class LC743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = -1;
            }
        }
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        if (N >= 0) System.arraycopy(graph[K], 1, distance, 1, N);
        distance[K] = 0;
        boolean[] visited = new boolean[N + 1];
        visited[K] = true;

        for (int i = 1; i <= N - 1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = 1;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && distance[j] != -1 && distance[j] < minDistance) {
                    minDistance = distance[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 1; j <= N; j++) {
                if (graph[minIndex][j] != -1) {
                    if (distance[j] != -1) {
                        distance[j] = Math.min(distance[j], distance[minIndex] + graph[minIndex][j]);
                    } else {
                        distance[j] = distance[minIndex] + graph[minIndex][j];
                    }
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == -1) {
                return -1;
            }
            maxDistance = Math.max(distance[i], maxDistance);
        }

        return maxDistance;
    }
}
