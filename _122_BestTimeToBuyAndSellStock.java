package LeetCode;
//可以多次进行交易（多次买入卖出）
//从第一个开始，连续递增的区间为一次买入卖出
public class _122_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
       int profit = 0;
       for(int i =0;i<prices.length-1;i++){
           if(prices[i+1]>prices[i]){
               profit+=prices[i+1]-prices[i];
           }
       }
       return profit;
    }
    public static void main(String[]args){
        int[]prices = {7,1,5,3,6,4};
        _122_BestTimeToBuyAndSellStock it = new _122_BestTimeToBuyAndSellStock();
        int res = it.maxProfit(prices);
        System.out.print(res);
    }

}
