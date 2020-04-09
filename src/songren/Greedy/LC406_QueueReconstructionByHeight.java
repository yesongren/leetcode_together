package songren.Greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by yesongren on 2020/4/9
 * 406. Queue Reconstruction by Height
 */
public class LC406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> res = new LinkedList<>();

        for (int[] i : people) {
            res.add(i[1], i);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
