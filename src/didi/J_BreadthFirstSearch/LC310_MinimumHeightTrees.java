package src.didi.J_BreadthFirstSearch;

import java.util.*;

public class LC310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] deg = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) map.put(i,new ArrayList<Integer>());

        for (int[] edge : edges) {
            deg[edge[0]]++;
            deg[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) q.offer(i);
        }

        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                res.add(curr);
                for (Integer parent : map.get(curr)) {
                    deg[parent]--;
                    if (deg[parent] == 1) q.offer(parent);
                }
            }
        }

        return res;
    }
}
