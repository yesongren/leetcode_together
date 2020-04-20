package songren.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yesongren on 2020/4/20
 * 802. Find Eventual Safe States
 */
public class LC802_FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int N = graph.length;
        int[] unsafe = new int[N];
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            if (unsafe[i] == 2 || dfs(i, graph, unsafe, set))
                res.add(i);
        }
        return res;
    }

    private boolean dfs(int i, int[][] graph, int[] unsafe, Set<Integer> set) {
        if (unsafe[i] == 1)
            return false;
        if (unsafe[i] == 2)
            return true;
        int[] targets = graph[i];
        if (targets.length == 0)
            return true;
        for (int k = 0; k < targets.length; k++) {
            if (set.contains(targets[k]))
                return false;
            set.add(targets[k]);
            if (!dfs(targets[k], graph, unsafe, set)) {
                unsafe[targets[k]] = 1;
                return false;
            } else
                unsafe[targets[k]] = 2;
            set.remove(targets[k]);
        }
        return true;
    }
}
