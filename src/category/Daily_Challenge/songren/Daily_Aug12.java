package category.Daily_Challenge.songren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yesongren on 2020/8/12
 * 133. Clone Graph
 */
public class Daily_Aug12 {
    public class UndirectedGraphNode {
        int val;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            val = x;
            neighbors = new ArrayList<>();
        }
    }

    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    // Time: O(E), Space: O(n)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode copy = new UndirectedGraphNode(node.val);
        map.put(node, copy);
        for (UndirectedGraphNode n : node.neighbors) {
            if (map.containsKey(n)) copy.neighbors.add(map.get(n));
            else copy.neighbors.add(cloneGraph(n));
        }
        return copy;
    }
}
