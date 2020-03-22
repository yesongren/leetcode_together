package didi.slidingwindow;

class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int replace = 0;
        int result = 0;

        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) replace++;
            while (replace > K) {
                if (A[left] == 0) replace--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}