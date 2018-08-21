package LeetCode;

public class max_Profit {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int min = prices[0];
        int res = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            else {
                res = Math.max(res,prices[i]-min);
            }
        }
        return res;
    }
    public static void main(String[]args){
        int[]num = {7,1,5,3,6,4};
        max_Profit it = new max_Profit();
        System.out.print(it.maxProfit(num));

    }
}
