package LeetCode;
//C[i]=A[0]*A[1]..*A[i-1]
//D[i]=D[i+1]*...*D[n-1]
//res = C[i]*D[i]
//C[i] = C[i-1]*A[i-1]
//D[i] = D[i+1]*A[i+1]
public class product_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int[]C = new int[nums.length];
        int[]D = new int[nums.length];
        int[]res = new int[nums.length];
        if(nums.length==0)
            return res;
        C[0] = 1;
        for(int i =1 ;i<nums.length;i++){
            C[i] = C[i-1] * nums[i-1];
        }
        D[nums.length-1] = 1;
        for(int i =nums.length-2 ;i>=0;i--){
            D[i] = D[i+1] *nums[i+1];
        }
        for(int i =0 ;i<nums.length;i++){
            res[i] = C[i] *D[i];
        }
        return res;
    }
}
