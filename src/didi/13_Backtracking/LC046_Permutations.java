package didi.backtracking;

// use boolean array is faster
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0 || nums == null) return result;
        Helper(result, nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void Helper(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                curr.add(nums[i]);
                visited[i] = true;
                Helper(res, nums, curr, visited);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0 || nums == null) return result;
        Helper(result, nums, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void Helper(List<List<Integer>> res, int[] nums, List<Integer> curr, HashSet<Integer> set) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(nums[i])){
                    curr.add(nums[i]);
                    set.add(nums[i]);
                    Helper(res, nums, curr, set);
                    set.remove(nums[i]);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
