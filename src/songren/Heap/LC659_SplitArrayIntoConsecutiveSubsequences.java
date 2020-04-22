package songren.Heap;

import java.util.Collection;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by yesongren on 2020/4/22
 * 659. Split Array into Consecutive Subsequences
 */
public class LC659_SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int num : nums) {
            PriorityQueue<Integer> queue = map.get(num - 1);
            int value;
            if (queue == null || queue.isEmpty()) {
                value = 1;
            } else {
                value = queue.poll() + 1;
            }
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            map.get(num).add(value);
        }
        return map.values().stream().flatMap(Collection::stream).noneMatch(i -> i < 3);
    }
}
