package src.didi.R_Heap;

import java.util.HashMap;
import java.util.Map;

public class LC659_SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), next = new HashMap<>();

        for (int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);

        for (int i : nums) {
            if (freq.get(i) == 0) continue;
            else if (next.getOrDefault(i, 0) > 0) {
                next.put(i, next.get(i) - 1);
                next.put(i+1, next.getOrDefault(i + 1, 0) + 1);
                freq.put(i, freq.get(i) - 1);
            } else if (freq.getOrDefault(i, 0) > 0 && freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i, freq.get(i) - 1);
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                next.put(i + 3, next.getOrDefault(i + 3, 0) + 1);
            } else return false;
        }

        return true;
    }
}
