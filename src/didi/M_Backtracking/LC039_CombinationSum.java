package didi.backtracking;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0 || candidates == null) return result;
        Arrays.sort(candidates);
        Helper(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void Helper(List<List<Integer>> res, int[] candidates, int target, int index, List<Integer> currList) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(currList));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) break;
                currList.add(candidates[i]);
                Helper(res, candidates, target - candidates[i], i, currList);
                currList.remove(currList.size() - 1);
            }
        }
    }
}