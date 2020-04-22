package songren.Heap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yesongren on 2020/4/22
 * 373. Find K Pairs with Smallest Sums
 */
public class LC373_FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1)));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (queue.size() == k && nums1[i] + nums2[j] > queue.peek().get(0) + queue.peek().get(1)) {
                    break;
                }

                if (queue.size() == k) {
                    queue.poll();
                }
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                queue.add(pair);
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            res.add(0, queue.poll());
        }
        return res;
    }
}
