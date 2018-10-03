package LeetCode;

//Input:[7,8,9,11,12]
//Output:1
//思路:
//将数组进行归位，如果nums[i]!=i+1，则i位置元素与nums[i]-1元素交换
//注意下标可能溢出，所以只交换那些不会造成下标溢出的元素
//交换过程完成之后，遍历一遍数组，一旦遇到i位置的元素nums[i]!=i+1，则该i+1为返回值
//时间复杂度O(n)

public class first_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        int min_Positive = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i])
                    swap(nums, i, nums[i] - 1);
                else break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                min_Positive = i + 1;
                break;
            }
        }
        return min_Positive;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        first_Missing_Positive it = new first_Missing_Positive();
        int res = it.firstMissingPositive(nums);
        System.out.println(res);

    }
}
