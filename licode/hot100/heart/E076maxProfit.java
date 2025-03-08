package heart;

public class E076maxProfit {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minprice ){
                minprice = prices[i];
            }else if(prices[i] - minprice > maxProfit){
                //用后面天数的价钱减去最低价，防止在没有买入时卖出
                maxProfit = prices[i] - minprice;
            }
        }
        return maxProfit;
    }

}
