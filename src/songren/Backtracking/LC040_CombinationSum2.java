package songren.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by yesongren on 2020/3/8
 * 40. Combination Sum II
 */
public class LC040_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> one = new ArrayList<>();
        Arrays.sort(candidates);
        search(one, new ArrayList<Integer>(), candidates, target, new Stack<Integer>());
        return one;
    }

    public static void search(List<List<Integer>> one, List<Integer> two, int[] candidates, int target, Stack<Integer> record) {
        if (target == 0) {
            List<Integer> vessel = new ArrayList<>(two);
            if (!one.contains(vessel)) one.add(vessel);
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (target >= candidates[i]) {
                    if (two.isEmpty() || (i > record.peek() && two.get(two.size() - 1) <= candidates[i])) {
                        two.add(candidates[i]);
                        record.push(i);
                        search(one, two, candidates, target - candidates[i], record);
                        two.remove(two.size() - 1);
                        record.pop();
                    }
                } else break;
            }
        }
    }
}
