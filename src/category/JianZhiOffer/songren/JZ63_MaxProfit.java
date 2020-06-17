package category.JianZhiOffer.songren;

/**
 * Created by yesongren on 2020/6/16
 * 面试题63. 股票的最大利润
 */
public class JZ63_MaxProfit {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minValue = Math.min(minValue, price);
            maxProfit = Math.max(maxProfit, price - minValue);
        }
        return maxProfit;
    }
}
