package didi.greedy;

class Solution {
    // Base Solution
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        if (gas.length != cost.length) return -1;

        int size = gas.length;

        int[] station = new int[size*2];

        for (int i = 0; i < size; i++) station[i] = gas[i] - cost[i];
        for (int i = size; i < size * 2; i++) station[i] = station[i - size];

        int sum = 0, index = -1;

        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                sum += station[i + j];
                if (sum < 0) break;
            }
            if (sum < 0) {
                sum = 0;
            } else return i;
        }

        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) return -1;

        int sum = 0, total = 0, index = -1;

        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if(sum < 0) {
                index = i;
                sum = 0;
            }
        }

        return total < 0 ? -1 : index + 1;
    }
}