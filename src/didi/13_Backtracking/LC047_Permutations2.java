package didi.backtracking;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0 || nums == null) return result;
        Arrays.sort(nums);
        Helper(result, nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void Helper(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        } else {
            int preNum = nums[0] - 1;
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                if (nums[i] != preNum){
                    preNum = nums[i];
                    curr.add(nums[i]);
                    visited[i] = true;
                    Helper(res, nums, curr, visited);
                    visited[i] = false;
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

    // just use if condition
    private void Helper(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                curr.add(nums[i]);
                visited[i] = true;
                Helper(res, nums, curr, visited);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}