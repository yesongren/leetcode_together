package songren.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yesongren on 2020/4/22
 * 378. Kth Smallest Element in a Sorted Matrix
 */
public class LC378_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((integer, t1) -> t1 - integer);
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.add(aMatrix[j]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
}
