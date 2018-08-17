package LeetCode;
//题目所在地址:
// https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=46&tqId=29177&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
//给定一个无序数组，数组中的元素可能存在重复值
//给定一个target，要求找到两个数的和为target，并返回这两个数的下标(下标小的在前面)
//思路：我一开始的思路是将数组排成有序，并另外开拓一个空间保存原数组，然后从有序的数组中找两个数的
//和为target的方法为定义两个首尾指针，找到之后去原数组中遍历获得原来的下标，这样空间复杂度为O(N),时间复杂度为O(NlogN)
//更加优化的思路为:
//用一个hashmap，key为元素，value为下标
//一边进行数组遍历一边初始化hashmap
//因为可能有重复元素，所以遍历的时候先不着急将元素放入hashmap中，而是先判断target-当前元素
//是否在hashmap中，如果不在，则放入当前元素，
//否则找到一组满足条件的值了
//如果（0,..i-1上）有重复元素，那么保存的是最后一个重复元素的下标(也可以设置为当有重复元素的时候，不去覆盖下标)
/*
      * 用 HashMap 存储数组元素和索引的映射，在访问到 nums[i] 时，判断 HashMap 中是否存在 target - nums[i]
      * 如果存在说明 target - nums[i] 所在的索引和 i 就是要找的两个数。
      * 该方法的时间复杂度为 O(N)，空间复杂度为 O(N)，使用空间来换取时间。
  */

import java.util.*;

public class two_sum {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();//key:元素,value:下标
        for (int i = 0; i < numbers.length; i++) {
            if (!hashMap.containsKey(target - numbers[i]))
                hashMap.put(numbers[i], i);
            else {
                int index = hashMap.get(target - numbers[i]);
                res[0] = index + 1;
                res[1] = i + 1;
                break;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        two_sum it = new two_sum();
        int[] numbers = {0, 0, 4, 0};

        int[] res = it.twoSum(numbers, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
