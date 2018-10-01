package LeetCode;
import java.util.Arrays;

//Given array nums = [-1, 2, 1, -4], and target = 1.
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//这道题让我们求最接近给定值的三数之和，是在之前那道 3Sum 三数之和的基础上又增加了些许难度，
// 那么这道题让我们返回这个最接近于给定值的值，即我们要保证当前三数和跟给定值之间的差的绝对值最小，
// 所以我们需要定义一个变量diff用来记录差的绝对值，然后我们还是要先将数组排个序，然后开始遍历数组，
// 思路跟那道三数之和很相似，都是先确定一个数，然后用两个指针left和right来滑动寻找另外两个数，
// 每确定两个数，我们求出此三数之和，然后算和给定值的差的绝对值存在newDiff中，
// 然后和diff比较并更新diff和结果closest即可
public class threeSum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int minDeta = Integer.MAX_VALUE;
        int res = -1;
        Arrays.sort(nums);
        for(int c = nums.length-1;c>=2;c--){
            int twoSum = target-nums[c];
            int a =0;
            int b=c-1;
            while (a<b){
                int curDeta =Math.abs(nums[a]+nums[b]+nums[c]-target);
                if(curDeta<minDeta){
                    res = nums[a]+nums[b]+nums[c];
                    minDeta = curDeta;
                }
                if(nums[a]+nums[b]>twoSum)
                    b--;
                else if(nums[a]+nums[b]<twoSum)
                    a++;
                else return target;

            }
        }
        return res;
    }
    public static void main(String[]args){
        int[]nums = {-1, 2, 1, -4};
        int target = 1;
        threeSum_Closest it = new threeSum_Closest();
        int res = it.threeSumClosest(nums,target);
        System.out.println(res);

    }


}
