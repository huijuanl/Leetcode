package LeetCode;
//一个数组中需要调整为升序的最小连续子区间
//Input: [2, 6, 4, 8, 10, 9, 15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9]
public class find_UnsortedSubarray {

    //O(n) Time O(1) Space
    //最短数组的起始点的特征为:右边存在比它小的元素
    //终止点特征为:左边存在比它大的元素
    //参考自最佳答案
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = -1;

        //从左往右遍历，如果A[i]小于左边所有元素的最大值，则A[i]可能是右边界
        //从右往左遍历，如果A[i]大于右边所有元素的最小值，则A[i]可能是左边界
        int max = nums[0];//左边所有元素的最大值
        int min = nums[nums.length-1];//右边所有元素的最小值
        for(int i =1;i<nums.length;i++){
            max = Math.max(max, nums[i]);
            if (nums[i] < max) end = i;
        }
        for(int i =nums.length-2;i>=0;i--){
            min = Math.min(min, nums[i]);
            if (nums[i] > min) start = i;
        }
        return start==-1?0:end-start+1;

    }

    //时间复杂度O(n^2)，自己写的
    public int findUnsortedSubarray2(int[] nums) {
        int a = 0;
        int b = nums.length - 1;
        while (a < nums.length - 1) {
            if (nums[a] <= nums[a + 1])
                a++;
            else break;
        }
        while (b > 0) {
            if (nums[b] >= nums[b - 1])
                b--;
            else break;
        }
        if (a >= b)
            return 0;
        while (a >= 0 && b < nums.length && nums[a] > nums[b]) {
            if (a >= 0 && nums[a] > nums[b])
                a--;
            b++;
        } //可能的最短左右区间边界[a+1,b-1]
        int i = a + 1;
        //向两边扩展
        while (i < b) {
            while (a >= 0 && nums[i] < nums[a]) {
                a--;
            }
            while (b < nums.length && nums[i] > nums[b]) {
                b++;
            }
            i++;
        }
        return b - a - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        find_UnsortedSubarray it = new find_UnsortedSubarray();
        int res = it.findUnsortedSubarray(nums);
        System.out.print(res);

    }
}
