package src.didi.S_UnionFind;

public class LC959_RegionsCutBySlashes {
    static class UnionFind {
        int size;
        int[] father;

        UnionFind (int size) {
            this.size = size;
            this.father = new int[size];

            for (int i = 0; i < size; i++) {
                father[i] = i;
            }
        }

        public void union(int a, int b) {
            father[find(a)] = find(b);
        }

        public int find(int a) {
            if (father[a] != a)
                father[a] = find(father[a]);
            return father[a];
        }
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        UnionFind uf = new UnionFind(4 * N * N);

        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++) {
                int id = 4 * (r * N + c);
                char curr = grid[r].charAt(c);
                if (curr != '\\') {
                    uf.union(id, id + 1);
                    uf.union(id + 2, id + 3);
                }
                if (curr != '/') {
                    uf.union(id , id + 2);
                    uf.union(id + 1, id + 3);
                }

                if (r + 1 < N)
                    uf.union(id + 3, id + 4 * N);

                if (r - 1 >= 0)
                    uf.union(id, (id - 4 * N) + 3);

                if (c + 1 < N)
                    uf.union(id + 2, (id + 4) + 1);

                if (c - 1 >= 0)
                    uf.union(id + 1, (id - 4) + 2);
            }

        int ans = 0;

        for (int i = 0; i < 4 * N * N; i++) {
            if (uf.find(i) == i)
                ans++;
        }

        return ans;
    }
}
