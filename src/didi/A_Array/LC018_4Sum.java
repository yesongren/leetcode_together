package didi;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length-3; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length-2; j++){
                if (j > i+1 && nums[j] == nums[j-1]) continue; // bug 1
                int twoSum = target - nums[i] - nums[j];
                int twoSumMin = nums[j+1] + nums[j+2];
                int twoSumMax = nums[nums.length-1] + nums[nums.length-2];
                if (twoSum < twoSumMin || twoSum > twoSumMax) continue;
                int left = j+1, right = nums.length-1;
                while (left < right){
                    if (nums[left] + nums[right] + nums[i] + nums[j] < target) left++;
                    else if (nums[left] + nums[right] + nums[i] + nums[j] > target) right--;
                    else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}