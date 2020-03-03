package songren.Greedy;

/**
 * Created by yesongren on 2020/3/3
 * 122. Best Time to Buy and Sell Stock II
 */
public class LC122_BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }
}
