package songren.DynamicProgramming;

/**
 * Created by yesongren on 2020/3/25
 * 121. Best Time to Buy and Sell Stock
 */
public class LC121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
