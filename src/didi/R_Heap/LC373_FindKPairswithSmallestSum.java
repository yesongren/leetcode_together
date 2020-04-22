package src.didi.R_Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC373_FindKPairswithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] l1, int[] l2) -> l1[0] + l1[1] - l2[0] - l2[1]);
        List<List<Integer>> res = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) return res;

        for (int i = 0; i < nums1.length && i < k; i++) {
            queue.offer(new int[] {nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !queue.isEmpty()) {
            int[] curr = queue.poll();
            res.add(Arrays.asList(curr[0], curr[1]));
            if (curr[2] == nums2.length - 1) continue;
            queue.offer(new int[] {curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }

        return res;
    }
}
