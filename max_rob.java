package LeetCode;
//robber问题
//用动态规划求解
public class max_rob {
    //我写的动态规划，时间复杂度O(n^2)，不够优化
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i >= 2) {
                for (int j = 0; j < i - 1; j++)
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            } else dp[i] = nums[i];
            max = Math.max(dp[i], max);

        }
        return max;
    }
    //最优动态规划
    public int rob2(int[] nums) {
        if(nums.length==0)
            return 0;
        int[][] dp = new int[nums.length][2];//抢或不抢,0表示不抢第i个，1表示抢第i个
        dp[0][1] = nums[0];
        int max =nums[0];
        for (int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] =dp[i-1][0]+nums[i];
            int tmp = Math.max(dp[i][0], dp[i][1]);
            max = Math.max(tmp,max);
            }
        return max;
    }
}
