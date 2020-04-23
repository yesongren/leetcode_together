package songren.UnionFind;

/**
 * Created by yesongren on 2020/4/23
 * 959. Regions Cut By Slashes
 */
public class LC959_RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        DSU dsu = new DSU(4 * N * N);
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                int root = 4 * (row * N + column);
                char currChar = grid[row].charAt(column);
                if (currChar != '/') {
                    dsu.union(root + 2, root);
                    dsu.union(root + 1, root + 3);
                }
                if (currChar != '\\')
                    dsu.union(root + 2, root + 3);
                dsu.union(root + 1, root);

                if (row + 1 < N)
                    dsu.union(root + 3, (root + 4 * N));

                if (row - 1 >= 0)
                    dsu.union(root, (root - 4 * N) + 3);

                if (column + 1 < N)
                    dsu.union(root + 2, root + 4 + 1);
                if (column - 1 >= 0)
                    dsu.union(root + 1, root - 4 + 2);
            }
        }
        int ans = 0;
        for (int i = 0; i < 4 * N * N; i++)
            if (dsu.find(i) == i)
                ans++;
        return ans;
    }

    class DSU {
        int[] parent;

        DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int c1, int c2) {
            int p1 = find(c1);
            int p2 = find(c2);
            if (p1 != p2)
                parent[p1] = p2;
        }
    }
}
