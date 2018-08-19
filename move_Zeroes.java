package LeetCode;

//把一个数组中所有的零都移到末尾
//零区间最左边的下标初始化为-1
//思路:零区间的最左边的零与下一个不为0的 位置的元素交换
//交换完之后，零区间左端点+1
public class move_Zeroes {
    public void moveZeroes(int[] nums) {
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (left == -1) {
                    left = i;
                }
            } else {
                if (left != -1) {
                    swap(nums, left, i);
                    left++;
                }
            }

        }
    }
    //利用了快排的思想，nums[i]!=0 和nums[i]==0
    //一次快排，没有主元插入，并不会改变元素的顺序，比较简洁
    public void moveZeroes2(int[] nums) {
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0) {
                left++;
                swap(nums,left,i);
            }
        }

    }
    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        move_Zeroes it = new move_Zeroes();
        int[] nums = {2, 1, 3, 3, 12};
        it.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
    }
}
