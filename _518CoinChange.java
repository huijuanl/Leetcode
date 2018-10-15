package LeetCode;
//题意：给一个总额amount, 给若干个面额不同的硬币的集合coins, 问组成总额的方案数.
public class _518CoinChange {
    //我写的动态规划
    //dp[i][j]表示amount为j,coins[0,1...i]共i+1个币种时的换钱种类数
    //递推公式：
    //因为每一个币种都可以选无限张，所以选第i个币种时，前0,1...i-1个币种已经选完，
    // 对于第i个币种，可能选0张，也可能选至少一张，那么可以分为两种情况：
    //(1)如果第i个币种一张都不选，也就是0张，那么dp[i][j] = dp[i-1][j]
    //(2)如果第i个币种至少选了一张，我把这一张单独拿出来，总钱数还有j-coins[i]，
    //那么需要确定总钱数为j-coins[i]时有多少种选择方法，dp[i][j] = dp[i][j-coins[i]]
    //把(1)(2)的种数加起来，那么dp[i][j] = dp[i-1][j]+dp[i][j-coins[i]];
    public int change(int amount, int[] coins) {
        if(amount==0)
            return 0;
        if(coins==null||coins.length==0)
            return 1;

        int[][]dp = new int[coins.length][amount+1];
        for(int k=0 ;k*coins[0]<=amount;k++){
            dp[0][coins[0]*k] = 1;
        }
        for(int i =1;i<coins.length;i++){
            for(int j =0;j<=amount;j++){
                if(j-coins[i]>=0)
                dp[i][j] = dp[i-1][j]+dp[i][j-coins[i]];
                else dp[i][j] = dp[i-1][j];
            }

        }
        return dp[coins.length-1][amount];
    }
//简单DP.
//dp[i]表示总额为i时的方案数.
//转移方程:
// dp[i] = Σdp[i - coins[j]]; 表示 总额为i时的方案数 = 总额为i-coins[j]的方案数的加和.
// 记得初始化dp[0] = 1; 表示总额为0时方案数为1.
    public int change3(int amount, int[] coins){
        int[]dp = new int[amount+1];
        dp[0] = 1;
        for(int j =0;j<coins.length;j++){
            for(int i =coins[j];i<dp.length;i++){
                    dp[i]+=dp[i-coins[j]];
            }
        }
        return dp[amount];

    }
    //更快
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int i = coin; i <= amount; i++) dp[i] += dp[i-coin];
        }
        return dp[amount];
    }
    public static void main(String[]args){
        int[]arr = {5,1,2};
        int amount  = 5;
        _518CoinChange it = new _518CoinChange();
        int res = it.change2(amount,arr);
        System.out.print(res);
    }
}
