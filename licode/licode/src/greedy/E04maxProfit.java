package greedy;

/**
 * 买卖股票的最佳时期
 */
public class E04maxProfit {
    public int maxProfit(int[] prices) {
        //[7,1,5,10,4,6]
        //  -6,4,5,-6,2  利润和：11
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i] - prices[i-1];
            if(price > 0){
                res += price;
            }
        }
        return res;
    }
}
