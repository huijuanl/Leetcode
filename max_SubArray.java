package LeetCode;
//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//For example, given the array[−2,1,−3,4,−1,2,1,−5,4],
//the contiguous subarray[4,−1,2,1]has the largest sum =6.
public class max_SubArray {
    public int maxSubArray(int[] A) {
        int[]dp = new int[A.length];//dp[i]表示以i结尾的子数组的最大和
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            dp[i] = A[i];
            if(i-1>=0){
                dp[i] = Math.max(dp[i],dp[i-1]+dp[i]);
            }
            maxSum = Math.max(dp[i],maxSum);
        }
        return maxSum;
    }
}
