package songren.UnionFind;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yesongren on 2020/4/23
 * 1202. Smallest String With Swaps
 */
public class LC1202_SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();

        DSU dsu = new DSU(100000);
        for (List<Integer> list : pairs)
            dsu.union(list.get(0), list.get(1));
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            int key = dsu.find(i);
            map.computeIfAbsent(key, unused -> new ArrayList<>()).add(i);
        }

        StringBuilder res = new StringBuilder(s);
        for (List<Integer> idx_list : map.values())
            if (idx_list.size() > 1)
                sort(res, idx_list);

        return res.toString();
    }

    private void sort(StringBuilder res, List<Integer> idx_list) {
        int len = idx_list.size();
        char[] array = new char[len];
        for (int i = 0; i < len; ++i)
            array[i] = res.charAt(idx_list.get(i));
        Arrays.sort(array);
        for (int i = 0; i < len; ++i)
            res.setCharAt(idx_list.get(i), array[i]);
    }
}

class DSU {
    int[] parent;

    public DSU(int len) {
        parent = new int[len];
        for (int i = 0; i < len; ++i)
            parent[i] = i;
    }

    public int find(int x) {
        return parent[x] != x ? parent[x] = find(parent[x]) : x;
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
