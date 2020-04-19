package src.didi.P_Graph;

import java.util.*;

public class LC332_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (List<String> list : tickets) {
            if(!map.containsKey(list.get(0))) {
                map.put(list.get(0), new PriorityQueue<String>(Arrays.asList(list.get(1))));
            } else {
                map.get(list.get(0)).offer(list.get(1));
            }
        }

        dfs("JFK", res, map);

        return res;
    }

    private void dfs (String start, LinkedList<String> res, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> q = map.get(start);

        while (q != null && !q.isEmpty()) {
            dfs(q.poll(), res, map);
        }

        res.addFirst(start);
    }
}
