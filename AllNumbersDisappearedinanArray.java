package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给一个大小为n的数组，里面所有的元素的值都在1~n之间，一些元素出现了两次，一些元素出现了一次
//找到所有没有出现的元素
//有两种方法:
//方法一:第一种思路，和剑指offer一样的思路，时间复杂度为O(n)，空间复杂度为O(1)，涉及到交换元素
//方法二最优思路,正负标记法，，时间复杂度为O(n)，空间复杂度为O(1)，不涉及到交换元素
//（1）第一次遍历，对每一个元素而言，将它所对应的下标所含的元素标为负数()
//（2）第二次遍历，找出元素值为正数所对应的下标，即为所求
public class AllNumbersDisappearedinanArray {
    //第一种思路，和剑指offer一样的思路，时间复杂度为O(n)，空间复杂度为O(1)，涉及到交换元素
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i) {
                if ((nums[i]) != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
                else break;
            }
        }
        List res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i)
                res.add(i + 1);
        }
        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //第二种思路，最优思路,正负标记法
    //第一次遍历，对每一个元素而言，将它所对应的下标所含的元素标为负数()
    //第二次遍历，找出元素值为正数所对应的下标，即为所求
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }

        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        AllNumbersDisappearedinanArray it = new AllNumbersDisappearedinanArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List res = it.findDisappearedNumbers2(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");

        }

    }
}
