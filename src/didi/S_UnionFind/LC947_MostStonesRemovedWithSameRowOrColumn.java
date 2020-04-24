package src.didi.S_UnionFind;

import java.util.HashSet;
import java.util.Set;

public class LC947_MostStonesRemovedWithSameRowOrColumn {
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
    public int removeStones(int[][] stones) {
        int N = stones.length;
        UnionFind uf = new UnionFind(20000);

        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10000);
        }

        Set<Integer> group = new HashSet<>();

        for (int[] stone : stones) {
            group.add(uf.find(stone[0]));
        }

        return N - group.size();
    }
}
