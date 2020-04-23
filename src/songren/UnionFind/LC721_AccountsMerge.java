package songren.UnionFind;

import java.util.*;

/**
 * Created by yesongren on 2020/4/23
 * 721. Accounts Merge
 */
class Node {
    Node parent;
    String name;
    String email;
}
public class LC721_AccountsMerge {

    private Map<String, Node> map = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String name = account.get(0);
            String s = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                if (!map.containsKey(account.get(i))) {
                    map.put(account.get(i), new Node());
                    map.get(account.get(i)).parent = map.get(account.get(i));
                    map.get(account.get(i)).name = name;
                    map.get(account.get(i)).email = account.get(i);
                }
                union(map.get(s), map.get(account.get(i)));
            }
        }

        Map<String, Set<String>> res = new HashMap<>();
        for (Map.Entry<String, Node> e : map.entrySet()) {
            Node key = find(map.get(e.getKey()));
            res.putIfAbsent(key.email, new TreeSet<>());
            res.get(key.email).add(e.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        for (Set<String> set : res.values()) {
            List<String> temp = new ArrayList<>(set);
            temp.add(0, map.get(temp.get(0)).name);
            result.add(temp);
        }
        return result;
    }

    private void union(Node x, Node y) {
        Node x1 = find(x);
        x1.parent = find(y);
    }

    private Node find(Node x) {
        if (x != x.parent)
            x.parent = find(x.parent);
        return x.parent;
    }
}
