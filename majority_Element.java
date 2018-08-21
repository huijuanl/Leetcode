package LeetCode;

public class majority_Element {
    public int target;
    public int majorityElement(int[] nums) {
        sort(nums,0,nums.length-1);
        int count =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==target)
                count++;
        }
        if(count>nums.length/2)
            return target;
        else return -1;
    }
    public void sort(int[]nums,int left,int right){

        int pivot = nums[left];
        int j =left;
        for(int i =left+1;i<=right;i++){
            if(nums[i]<pivot){
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums,left,j);
        if(j==nums.length/2) {
            target = nums[j];
            return;
        }
        else if(j<nums.length/2)
            sort(nums,j+1,right);
        else sort(nums,left,j-1);

    }
    public void swap(int[]nums,int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[]args){
        majority_Element it = new majority_Element();
        int[]nums = {3,2,3};
        System.out.print(it.majorityElement(nums));

    }
}
