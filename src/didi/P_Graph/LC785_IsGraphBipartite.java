package src.didi.P_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        char[] color = new char[graph.length];

        for (int u = 0; u < graph.length; u++) {
            if (graph[u].length != 0 && !vis[u]) {
                q.offer(u);
                vis[u] = true;
                color[u] = 'r';
                while(!q.isEmpty()) {
                    int curr = q.poll();
                    for (int i = 0; i < graph[curr].length; i++) {
                        int nei = graph[curr][i];
                        if (!vis[nei]) {
                            if (color[curr] == 'r') color[nei] = 'b';
                            else if (color[curr] == 'b') color[nei] = 'r';
                            q.offer(nei);
                            vis[nei] = true;
                        } else {
                            if (color[nei] == color[curr]) return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
