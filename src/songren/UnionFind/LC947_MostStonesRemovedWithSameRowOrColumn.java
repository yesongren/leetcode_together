package songren.UnionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yesongren on 2020/4/23
 * 947. Most Stones Removed with Same Row or Column
 */
public class LC947_MostStonesRemovedWithSameRowOrColumn {
    private int[] parent = new int[20000];

    public int removeStones(int[][] stones) {
        int length = stones.length;
        if (length <= 1) {
            return 0;
        }
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] stone : stones) {
            union(stone[0], stone[1] + 10000);
        }
        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(findFather(stone[0]));
        }
        return length - set.size();
    }

    private int findFather(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        while (a != parent[a]) {
            int temp = a;
            a = parent[a];
            parent[temp] = x;
        }
        return x;
    }

    private void union(int a, int b) {
        int aFind = findFather(a), bFind = findFather(b);
        if (aFind != bFind) {
            parent[aFind] = bFind;
        }
    }
}
