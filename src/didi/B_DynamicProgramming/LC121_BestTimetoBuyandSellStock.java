package src.didi.B_DynamicProgramming;

class LC121_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i : prices) {
            min = Math.min(i,min);
            res = Math.max(res, i - min);
        }
        return res;
    }
}