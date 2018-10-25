package LeetCode;
//http://www.cnblogs.com/grandyang/p/7776979.html
//不限次数交易，但是有手续费
//Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
//Buying at prices[0] = 1
//Selling at prices[3] = 8
//Buying at prices[4] = 4
//Selling at prices[5] = 9
public class _714maxProfit {
    public int maxProfit(int[] prices, int fee) {
        int[] sold = new int[prices.length];//sold[i]表示第i天后不持有股票的0-i天的利润,
        //那么可能有两种情况：1.第i天没有买入也没有卖出，同时前i-1天过后不持有股票；2.第i天卖出之前持有的股票
        int[] hold = new int[prices.length];
        hold[0] = -prices[0];//hold[i]表示第i天后持有股票的0-i天的利润
        //那么有两种情况：一种是第i天发生了买入，另一种是没有买入也没有卖出，仍然保持前i-1天持有股票的状态
        for(int i =1;i<prices.length;i++){
            sold[i] = Math.max(sold[i-1],hold[i-1]+prices[i]-fee);
            hold[i] = Math.max(hold[i-1],sold[i-1]-prices[i]);
        }
        return sold[prices.length-1];


    }
}
