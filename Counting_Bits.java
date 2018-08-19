package LeetCode;

public class Counting_Bits {
    public int[] countBits(int num) {
        int[]dp = new int[num+1];//dp[i] = (i&1)+dp[i/2];
        for(int i =1;i<dp.length;i++){
            dp[i] = (i&1)+dp[i>>1];
        }
        return dp;
    }
    public static void main(String[]args){
        Counting_Bits it = new Counting_Bits();
        int[]res = it.countBits(5);
        for(int i =0;i<res.length;i++)
            System.out.print(res[i]+" ");

    }
}
