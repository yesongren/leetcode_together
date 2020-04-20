package songren.Graph;

import java.util.*;

/**
 * Created by yesongren on 2020/4/20
 * 332. Reconstruct Itinerary
 */
public class LC332_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }

        visit(graph, "JFK", ans);
        return ans;
    }

    private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        Stack<String> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty()) {
            PriorityQueue<String> nbr;
            while ((nbr = graph.get(stack.peek())) != null &&
                    nbr.size() > 0) {
                stack.push(nbr.poll());
            }
            ans.add(0, stack.pop());
        }
    }
}
