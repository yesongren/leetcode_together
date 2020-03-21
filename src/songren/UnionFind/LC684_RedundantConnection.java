package songren.UnionFind;

/**
 * Created by yesongren on 2020/3/21
 * 684. Redundant Connection
 */
public class LC684_RedundantConnection {
    public static int findRoot(int[] parent, int vertex) {
        while (parent[vertex] > 0) vertex = parent[vertex];
        return vertex;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[10000];
        int[] e = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int m = findRoot(parent, edges[i][0]);
            int n = findRoot(parent, edges[i][1]);
            if (m == n) e = edges[i];
            else parent[m] = n;
        }
        return e;
    }
}
