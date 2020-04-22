package src.didi.R_Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC378_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(l -> matrix[l[0]][l[1]]));

        for (int i = 0; i < matrix.length && i < k; i++) {
            queue.offer(new int[] {i, 0});
        }

        int[] curr = new int[2];

        while (k-- > 0 && !queue.isEmpty()) {
            curr = queue.poll();
            if (curr[1] == matrix[0].length - 1) continue;
            queue.offer(new int[] {curr[0], curr[1] + 1});
        }

        return matrix[curr[0]][curr[1]];
    }
}
