package LeetCode;

import java.util.HashMap;

//给定一个整数数组，一个值k，需要找出所有连续子数组之和等于k的情况
//思路：求所有前缀数组的和，
// （1）如果s[j]-s[i]==k，那么i+1,,,,j上是一个符合要求的连续子数组
//（2）如果s[i]==k，那么0,,,i上也是一个符合要求的连续子数组
public class subarray_Sum {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();//前缀和，前缀和出现的次数
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum==k)
                res++;
            if(hashMap.containsKey(sum-k)){
                int value = hashMap.get(sum-k);
                res+=value;
            }
            if(hashMap.containsKey(sum)){
                int value = hashMap.get(sum);
                hashMap.put(sum,value+1);
            }
            else hashMap.put(sum,1);

        }
        return res;
    }
    public static void main(String[]args){
        subarray_Sum it = new subarray_Sum();
        int[]num = {-3, 1, 2, -3, 4};
        int k =0;
        int res = it.subarraySum(num,k);
        System.out.print(res);
    }
}
