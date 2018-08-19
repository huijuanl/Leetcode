package LeetCode;

//You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
// Now you have 2 symbols + and -. For each integer,
// you should choose one from + and - as its new symbol.
//Input: nums is [1, 1, 1, 1, 1], S is 3.
//Output: 5
//Explanation:
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//(1)递归
//(2)动态规划:特殊背包问题
public class Target_Sum {
    int res = 0;

    //递归实现
    public int findTargetSumWays(int[] nums, int S) {
        process(nums, 0, 0, S);
        return res;
    }

    public void process(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                res++;
            }
            return;
        }
        process(nums, i + 1, nums[i] + sum, S);
        process(nums, i + 1, -nums[i] + sum, S);
    }

    public static void main(String[] args) {
        Target_Sum it = new Target_Sum();
        int[] nums = {0,0,0,0,1};//16
        int S =1;
        int res = it.findTargetSumWays2(nums, S);
        System.out.print(res);
    }

    //类似于背包问题，只不过每次为0还是c[i]变成了为-c[i]还是c[i]
    //要将j的坐标从[0,max]变为[-max,max]
    public int findTargetSumWays2(int[] nums, int S) {
        int max = 0;
        for (int i = 0; i < nums.length; i++)
            max += nums[i];
        if (S > max)
            return 0;
        int[][] dp = new int[nums.length][2 * max + 1];//dp[i][j]表示选完i个元素之后和为j-max时的组合数
//        dp[0][nums[0] + max] = 1;
//        dp[0][-nums[0] + max] = 1;//没有考虑:nums[0]==0这种情况
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++) {
                if(i-1>=0) {
                    if ((j - nums[i]) >= 0)
                        dp[i][j] += dp[i - 1][j - nums[i]];
                    if ((j + nums[i]) < dp[0].length)
                        dp[i][j] += dp[i - 1][j + nums[i]];
                }
                else {
                    if ((j - max) ==nums[i])
                        dp[i][j] += 1;
                    if ((j -max) == -nums[i])
                        dp[i][j] += 1;

                }

            }
        res = dp[nums.length - 1][S + max];
        return res;
    }
}
