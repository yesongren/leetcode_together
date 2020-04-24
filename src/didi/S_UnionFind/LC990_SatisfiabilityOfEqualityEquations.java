package src.didi.S_UnionFind;

import java.util.ArrayList;
import java.util.List;

public class LC990_SatisfiabilityOfEqualityEquations {
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

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        List<int[]> notUF = new ArrayList<>();

        for (String s : equations) {
            char x = s.charAt(0);
            char y = s.charAt(s.length() - 1);

            String operation = s.substring(1, s.length() - 1);

            if (operation.equals("==")) uf.union(x - 'a', y - 'a');
            else notUF.add(new int[] {x - 'a', y - 'a'});
        }

        for (int[] eq : notUF) {
            if (uf.find(eq[0]) == uf.find(eq[1])) return false;
        }

        return true;
    }
}
