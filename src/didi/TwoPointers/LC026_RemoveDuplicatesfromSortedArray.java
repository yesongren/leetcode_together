package didi.twopointers;

class Solution {
    // no need to use HashSet
    public int removeDuplicates1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if(set.add(nums[i])) {
                nums[j++] = nums[i];
            }
        }
        return set.size();
    }
    // regular two pointers
    public int removeDuplicates(int[] nums) {
        int j = 0;

        for (int i = 1; i < nums.length; i++) { //start from 1
            if(nums[i] != nums[j]) {
                nums[++j] = nums[i]; // ++j not j++
            }
        }

        return j + 1;
    }
}