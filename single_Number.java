package LeetCode;

public class single_Number {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i =0;i<nums.length;i++){
            res = res^nums[i];

        }
        return res;
    }
}
