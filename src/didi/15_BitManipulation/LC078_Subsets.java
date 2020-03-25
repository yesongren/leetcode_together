package didi.bitmanipulation;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0 || nums == null) return result;

        Helper(result, nums, 0, new ArrayList<Integer>());

        return result;
    }

    public void Helper(List<List<Integer>> res, int[] nums, int index, List<Integer> curr) {
        res.add(new ArrayList<Integer>(curr)); //

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            Helper(res, nums, i + 1, curr);
            // res.add(new ArrayList<Integer>(curr)); //
            curr.remove(curr.size() - 1);
        }
    }
}