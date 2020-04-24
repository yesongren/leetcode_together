package src.didi.S_UnionFind;

import java.util.*;

public class LC721_AccountsMerge {
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
            father[find(a)] = father[find(b)];
        }

        public int find(int a) {
            if (father[a] != a)
                father[a] = find(father[a]);
            return father[a];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> emailToID = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToID.containsKey(email)){
                    int preIdx = emailToID.get(email);
                    uf.union(preIdx, i);
                } else
                    emailToID.put(email, i);
            }
        }

        Map<Integer, Set<String>> map = new HashMap<>();

        for (int idx = 0; idx < accounts.size(); idx++) {
            int fatherIdx = uf.find(idx);
            map.putIfAbsent(fatherIdx, new TreeSet<>());

            Set<String> curr = map.get(fatherIdx);
            for (int i = 1; i < accounts.get(idx).size(); i++) {
                curr.add(accounts.get(idx).get(i));
            }

            map.put(fatherIdx, curr);
        }

        for (int idx : map.keySet()) {
            List<String> emailList = new ArrayList<>();
            if (map.containsKey(idx)) {
                emailList.addAll(map.get(idx));
            }
            emailList.add(0, accounts.get(idx).get(0));
            res.add(emailList);
        }

        return res;
    }
}
