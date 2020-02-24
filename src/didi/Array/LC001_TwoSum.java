package didi;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            int rest = target - nums[i];
            if (map.containsKey(rest)){
                result[1] = i;
                result[0] = map.get(rest);
                return result;
            }
            else
                map.put(nums[i], i);
        }
        return result;
    }
}