package src.didi.S_UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1202_SmallestStringWithSwaps {
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

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int N = s.length();
        UnionFind uf = new UnionFind(N);
        for (List<Integer> pair : pairs)
            uf.union(pair.get(0), pair.get(1));

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int rootIdx = uf.find(i);
            map.putIfAbsent(rootIdx, new PriorityQueue<>());
            PriorityQueue<Character> pq = map.get(rootIdx);
            pq.offer(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(map.get(uf.find(i)).poll());
        }

        return sb.toString();
    }
}
