package src.didi.I_Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC406_QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        int num = people.length;
        List<int[]> res = new LinkedList<>();

        Arrays.sort(people, (a, b) -> a[0] == b[0]? a[1] - b[1] : b[0] - a[0]);

        for (int[] p : people) {
            res.add(p[1], p); // add base on k
        }

        return res.toArray(new int[num][2]);
    }
}
