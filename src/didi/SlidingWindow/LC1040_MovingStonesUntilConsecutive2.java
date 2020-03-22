package didi.slidingwindow;

class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        return new int[]{findMin(stones), findMax(stones)};
    }

    int findMin(int[] stones) {
        int n = stones.length;
        int i = 0;
        int min = n;

        for(int j = 0; j < n; ++j) {
            while (stones[j] - stones[i] >= n) ++i;
            if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2)
                min = Math.min(min, 2);
            else
                min = Math.min(min, n - (j - i + 1));
        }

        return min;
    }

    int findMax(int[] stones) {
        int sum = 0;

        for(int i = 1; i < stones.length; ++i) {
            sum += stones[i] - stones[i-1] - 1;
        }

        int n = stones.length;

        if(n >= 1 && stones[1] != stones[0] + 1) { // left 2 not close
            if(n >= 2 && stones[n-1] != stones[n-2] + 1) { // right 2 not close
                int gap1 = stones[1] - stones[0] - 1;
                int gap2 = stones[n-1] - stones[n-2] - 1;
                return sum - Math.min(gap1, gap2);
            }
        }

        return sum;
    }
}