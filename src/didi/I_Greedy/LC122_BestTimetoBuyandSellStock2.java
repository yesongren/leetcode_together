package didi.greedy;

class Solution {
    // valley first then peak
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int i = 0;
        int valley = prices[0], peak = prices[0], max = 0;

        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++; // -1
            peak = prices[i];

            max += peak - valley;
        }

        return max;
    }
}