package src.didi.P_Graph;

import java.util.*;

public class LC133_CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(node);
        map.put(node, null);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node newCurr = new Node(curr.val);
            map.put(curr, newCurr);
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, null);
                    q.offer(neighbor);
                }
            }
        }

        for (Node n : map.keySet()) {
            Node copy = map.get(n);
            for (Node nei : n.neighbors) {
                copy.neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
