package didi.bitmanipulation;

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int n: nums) sum += ((n >> i) & 1);
            sum %= 3;
            res |= sum << i;
        }

        return res;
    }
}