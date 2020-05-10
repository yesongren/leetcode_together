package src.category.JianZhiOffer.didi;

import java.util.PriorityQueue;

public class JZ40_TopK {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        int j = 0;
        for (int e : heap) res[j++] = e;

        return res;
    }
}
