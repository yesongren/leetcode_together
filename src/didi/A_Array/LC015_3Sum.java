package didi;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length < 3 || nums == null) return result;
        // int target = nums[0]; // bug 4 [0,0,0]
        for (int i = 0; i < nums.length-2; i++){
            if (nums[i] > 0) return result;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = nums[i];
            int left = i+1, right = nums.length-1;
            while (left < right){ // bug 5
                if (nums[left] + nums[right] + target > 0) right--; // bug 1
                else if (nums[left] + nums[right] + target < 0) left++;
                else{ // bug 7
                    result.add(Arrays.asList(target,nums[left],nums[right])); // bug 2
                    while (left < right && nums[left] == nums[left+1]) left++; // bug 6
                    while (left < right && nums[right] == nums[right-1]) right--; // bug 3
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}