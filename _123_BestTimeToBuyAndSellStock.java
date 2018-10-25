package LeetCode;
//股票的最大利润（至多两次交易，包括只进行一次交易）
//遍历，计算出第x天之前一次交易可以得到的最大收益，存储在formmer[n]中
//遍历，计算出第x天之后一次交易可以得到的最大收益，存储在latter[n]中
//遍历，计算formmer[i] + latter[i] 得到最大收益max
//动态规划，时间复杂度为O(n)
public class _123_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int[]formmer = new int[prices.length];
        int[]latter = new int[prices.length];
        //[0,day]天内一次交易可以得到的最大收益
        //记录左区间的最小值和最大收益
        int min_left = prices[0];
        int max_profit = 0;
        for(int day =0;day<prices.length;day++){
            max_profit = Math.max(prices[day]-min_left,max_profit);
            min_left = Math.min(min_left,prices[day]);
            formmer[day] = max_profit;
        }
        ////[day,n-1]天内一次交易可以得到的最大收益
        //记录右区间的最大值和最大收益
        int max_right= prices[prices.length-1];
        max_profit = 0;
        for(int day =prices.length-2;day>=0;day--){
            max_profit = Math.max(max_right-prices[day],max_profit);
            max_right = Math.max(max_right,prices[day]);
            latter[day] = max_profit;
        }
        //求和，formmer[i]+latter[i+1]最大
        int profit = 0;
        for(int i =0;i<prices.length;i++){
            profit = Math.max(formmer[i]+(i<prices.length-1?latter[i+1]:0),profit);
        }

        return profit;
    }
    public static void main(String[]args){
        int[]prices = {6,1,3,2,4,7};
        _123_BestTimeToBuyAndSellStock it = new _123_BestTimeToBuyAndSellStock();
        int res = it.maxProfit(prices);
        System.out.print(res);
    }
}
